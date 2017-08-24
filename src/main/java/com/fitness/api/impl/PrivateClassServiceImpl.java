package com.fitness.api.impl;

import com.fitness.api.dao.ImgDao;
import com.fitness.api.dao.PrivateClassDao;
import com.fitness.api.dao.PrivateClassTimeDao;
import com.fitness.api.domain.*;
import com.fitness.api.dto.PrivateClassDTO;
import com.fitness.api.service.PrivateClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 私教课业务逻辑层
 * Created on 2017/7/1.
 */
@Service
public class PrivateClassServiceImpl implements PrivateClassService, PageService {

    @Autowired
    private PrivateClassDao privateClassDao;
    @Autowired
    private ImgDao imgDao;
    @Autowired
    private PrivateClassTimeDao privateClassTimeDao;

    /**
     * 创建私教课程
     *
     * @param privateClass
     * @return
     */
    @Override
    public BaseResult add(PrivateClass privateClass) {
        int i = privateClassDao.insertPrivateClass(privateClass);
        if (i <= 0)
            return BaseResult.error("ADD_FAIL", "新增私教失败");
        Long id = privateClass.getId();

        //批量新增图片
        if (null != privateClass.getImgList() && privateClass.getImgList().size() != 0) {
            List<Img> list = privateClass.getImgList();
            for (Img img : list) {
                img.setThirdId(id);
            }
            imgDao.addBanner(list);
        }

        //批量新增时间课程表
        if (null != privateClass.getPrivateClassTimeList() && privateClass.getPrivateClassTimeList().size() != 0) {
            List<PrivateClassTime> list = privateClass.getPrivateClassTimeList();
            for (PrivateClassTime privateClassTime : list) {
                privateClassTime.setPrivateClassId(id);
            }
            privateClassTimeDao.batchInsertPrivateClassTime(list);
        }
        Long coachId = privateClass.getCoachId();
        Coach coach = new Coach();
        coach.setId(coachId);
        privateClassDao.updateCoachStatus(coach);
        return BaseResult.success("新增私教课成功");
    }

    /**
     * 根据id删除私教课
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        int i = privateClassDao.del(id);
        if (i <= 0)
            return BaseResult.error("DELETE_FAIL", "删除私教课失败");
        return BaseResult.success("删除私教课成功");
    }

    /**
     * 根据教练id 查询课程列表  分页
     *
     * @param pageNo
     * @param pageSize
     * @param coachId
     * @return
     */
    @Override
    public PageResult listByCoachId(Integer pageNo, Integer pageSize, Long coachId, String date) {
        int count = privateClassDao.listByCoachIdCount(coachId, date);
        if (count <= 0)
            return new PageResult(null, 0);
        List<PrivateClass> list = privateClassDao.listByCoachId(rowBounds(pageNo, pageSize), coachId, date);
        //查询时间段
        list.forEach(item -> {
            item.setPrivateClassTimeList(privateClassTimeDao.classTimesById(item.getId()));
        });
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 修改课程
     *
     * @param privateClass
     * @return
     */
    @Override
    public BaseResult update(PrivateClass privateClass) {
        int i = privateClassDao.updatePrivateClass(privateClass);
        return null;
    }

    /**
     * 根据会员id  查询我的课程  分页
     *
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */
    @Override
    public PageResult myClass(Integer pageNo, Integer pageSize, Long memberId) {

        return null;
    }

    /**
     * 根据课程id查看详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult coachClassInfo(Long id) {
        return null;
    }


    /**
     * 预约课程
     *
     * @param classId
     * @param timeId
     * @param memberId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult apply(Long classId, Long timeId, Long memberId) {
        //修改时间段为已预订
        privateClassTimeDao.updateTimeStatus(timeId);
        //增加member_class数据
        privateClassDao.insertPrivateClassParam(classId, memberId);
        return BaseResult.success("预约成功");
    }

    /**
     * 课程列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult bcList(Integer pageNo, Integer pageSize) {

        Integer count = privateClassDao.bcCount();
        if (count <= 0)
            return new PageResult(null, 0);
        List<PrivateClass> list = privateClassDao.bcList(rowBounds(pageNo, pageSize));
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 课程详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult classInfo(Long id) {

        PrivateClass privateClass = privateClassDao.classInfo(id);
        if (null == privateClass)
            return BaseResult.nonSuchResult();
        return BaseResult.success(privateClass);
    }

    /**
     * 根据日期查询私教课  分页
     *
     * @param pageNo
     * @param pageSize
     * @param date
     * @param memberId
     * @return
     */
    @Override
    public PageResult schedulePrivateClass(Integer pageNo, Integer pageSize, String date, Long memberId) {
        Integer count = privateClassDao.schedulePrivateClassCount(date, memberId);
        if (count <= 0)
            return new PageResult(null, 0);
        List<MemberClassExt> list = privateClassDao.schedulePrivateClass(rowBounds(pageNo, pageSize), date, memberId);
        return new PageResult(list, count, pageNo, pageSize);
    }
}
