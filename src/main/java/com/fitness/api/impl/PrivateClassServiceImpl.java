package com.fitness.api.impl;

import com.fitness.api.dao.CoachDao;
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

import java.util.List;

/**
 * 私教课业务逻辑层
 * Created on 2017/7/1.
 */
@Service
public class PrivateClassServiceImpl implements PrivateClassService,PageService {

    @Autowired
    private PrivateClassDao privateClassDao;
    @Autowired
    private ImgDao imgDao;
    @Autowired
    private PrivateClassTimeDao privateClassTimeDao;

    /**
     * 创建私教课程
     * @param privateClass
     * @return
     */
    @Override
    public BaseResult add(PrivateClass privateClass) {
        int i =privateClassDao.insertPrivateClass(privateClass);
        if(i<=0)
            return BaseResult.error("ADD_FAIL","新增评分失败");
        Long id = privateClass.getId();
        /* 批量新增图片 */
        if(null != privateClass.getImgList() && privateClass.getImgList().size() != 0){
            List<Img> list = privateClass.getImgList();
            for(Img img : list){
                img.setThirdId(id);
            }
            imgDao.addBanner(list);
        }
        /* 批量新增时间课程表 */
        if(null != privateClass.getPrivateClassTimeList() && privateClass.getPrivateClassTimeList().size() != 0){
            List<PrivateClassTime> list = privateClass.getPrivateClassTimeList();
            for(PrivateClassTime privateClassTime : list){
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
     * @param pageNo
     * @param pageSize
     * @param coachId
     * @return
     */
    @Override
    public PageResult listByCoachId(Integer pageNo, Integer pageSize, Long coachId) {
        int count = privateClassDao.listByCoachIdCount(coachId);
        if (count <= 0)
            return new PageResult(null, 0);
        List<PrivateClassDTO> list = privateClassDao.listByCoachId(rowBounds(pageNo, pageSize), coachId);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 修改课程
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
     * @param id
     * @return
     */
    @Override
    public BaseResult coachClassInfo(Long id) {
        return null;
    }
}
