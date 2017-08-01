package com.fitness.api.impl;

import com.fitness.api.dao.GradeDao;
import com.fitness.api.dao.GroupClassDao;
import com.fitness.api.dao.ImgDao;
import com.fitness.api.dao.MemberCardDao;
import com.fitness.api.domain.Grade;
import com.fitness.api.domain.GroupClass;
import com.fitness.api.domain.Img;
import com.fitness.api.service.GroupClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 团课-业务逻辑
 * Created on 2017/7/23.
 */
@Service
public class GroupClassServiceImpl implements GroupClassService, PageService {

    @Autowired
    private GroupClassDao groupClassDao;

    @Autowired
    private ImgDao imgDao;

    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private MemberCardDao memberCardDao;


    /**
     * 创建团课
     *
     * @param groupClass
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult add(GroupClass groupClass) {
        Integer count = groupClassDao.countByStartDate(groupClass.getStartDate(), groupClass.getCoachId());

        if (count > 0)
            return BaseResult.error("EXIST", "该时间段已存在");
        Integer result = groupClassDao.add(groupClass);
        if (result > 0) {
            if (null != groupClass.getImgList() && groupClass.getImgList().size() > 0) {
                List<Img> imgList = groupClass.getImgList();
                imgList.forEach(item -> {
                    item.setThirdId(groupClass.getId());
                });
                //新增轮播图
                imgDao.addBanner(imgList);
                //创建课程评分数据
                Grade classGrade = new Grade();
                classGrade.setClassId(groupClass.getId());
                classGrade.setClassScore(0);
                classGrade.setCoachScore(0);
                classGrade.setCoachScore(0);
                gradeDao.add(classGrade);
            }
            return BaseResult.success("创建团课成功");
        }
        return BaseResult.error("ADD_FAIL", "创建团课失败");
    }

    /**
     * 修改团课
     *
     * @param groupClass
     * @return
     */
    @Override
    public BaseResult update(GroupClass groupClass) {
        //校验时间段是否已存在课程
        Integer count = groupClassDao.countByStartDate(groupClass.getStartDate(), groupClass.getCoachId());
        if (count > 0)
            return BaseResult.error("UPDATE_FAIL", "该时间段已存在课程");
        Integer result = groupClassDao.update(groupClass);
        if (result > 0)
            return BaseResult.success("修改团课成功");
        return BaseResult.error("UPDATE_FAIL", "修改团课失败");
    }

    /**
     * 根据团课id删除
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        Integer result = groupClassDao.del(id);
        if (result <= 0)
            return BaseResult.error("DEL_FAIL", "删除失败");
        return BaseResult.success("删除成功");
    }

    /**
     * 团课详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult classInfo(Long id) {
        GroupClass groupClass = groupClassDao.classInfo(id);

        //banner图
        List<Img> imgList= imgDao.list(id);
        groupClass.setImgList(imgList);
        if (null == groupClass)
            return BaseResult.nonSuchResult();
        return BaseResult.success(groupClass);
    }

    /**
     * 报名团课
     *
     * @param memberId
     * @param classId
     * @return
     */
    @Override
    public BaseResult apply(Long memberId, Long classId) {
        //TODO 团课报名
        Integer count = groupClassDao.applyCount(memberId, classId);
        if (count > 0)
            return BaseResult.error("APPLY_FAIL", "已参加，不可重复参加");
        Integer result = groupClassDao.apply(memberId, classId);
        if (result > 0) {
            //修改会员卡剩余课程数
            memberCardDao.updateCLassSurplus(memberId);
            //修改 剩余席位
            groupClassDao.minusGroupClassTotal(classId);
            return BaseResult.success("团课报名成功");
        }
        return BaseResult.error("APPLY_FAIL", "团课报名失败");
    }

    /**
     * 根据场馆 查询团课列表  分页
     *
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */
    @Override
    public PageResult classListByStadium(Integer pageNo, Integer pageSize, Long stadiumId, String date) {
        Integer count = groupClassDao.groupClassCount(stadiumId, date);
        if (count <= 0)
            return new PageResult(null, 0);
        List<GroupClass> groupClassList = groupClassDao.groupClassList(rowBounds(pageNo, pageSize), stadiumId, date);
        return new PageResult(groupClassList, count, pageNo, pageSize);
    }

    /**
     * 团课列表  模糊搜索
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {

        if (!StringUtils.isNullOrEmpty(key))
            key = "%" + key + "%";
        Integer count = groupClassDao.count(key);
        if (count <= 0)
            return new PageResult(null, 0);
        List<GroupClass> list = groupClassDao.list(rowBounds(pageNo, pageSize), key);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据课程id查询团课详情
     *
     * @param classId
     * @return
     */
    @Override
    public BaseResult classInfoByClassId(Long classId) {
        GroupClass groupClass = groupClassDao.classInfoByClassId(classId);
        if (null == groupClass)
            return BaseResult.nonSuchResult();

        //课程评分
        Grade grade = new Grade();
        grade = gradeDao.getScoreByClassId(classId);
        groupClass.setGrade(grade);
        return BaseResult.success(groupClass);
    }


}
