package com.fitness.api.impl;

import com.fitness.api.dao.GroupClassDao;
import com.fitness.api.dao.ImgDao;
import com.fitness.api.domain.GroupClass;
import com.fitness.api.domain.Img;
import com.fitness.api.service.GroupClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * 团课-业务逻辑
 * Created on 2017/7/23.
 */
@Service
public class GroupClassServiceImpl implements GroupClassService {

    @Autowired
    private GroupClassDao groupClassDao;

    @Autowired
    private ImgDao imgDao;


    /**
     * 创建团课
     *
     * @param groupClass
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult add(GroupClass groupClass) {
        Integer count = groupClassDao.countByStartDate(groupClass.getStartDate());

        if (count > 0)
            return BaseResult.error("EXIST", "该时间段已存在");
        Integer result = groupClassDao.add(groupClass);
        if (result > 0) {
            List<Img> imgList = groupClass.getImgList();
            imgList.forEach(item -> {
                item.setThirdId(groupClass.getId());
            });
            //新增轮播图
            imgDao.addBanner(imgList);
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
        if (result > 0)
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
        if (null == groupClass)
            return BaseResult.nonSuchResult();
        return BaseResult.success(groupClass);
    }

    /**
     * 报名团课
     *
     * @param memberId
     * @param id
     * @return
     */
    @Override
    public BaseResult apply(Long memberId, Long id) {
        //TODO 团课报名
        Integer result = groupClassDao.apply(memberId, id);
        if (result > 0)
            return BaseResult.success("团课报名成功");
        return BaseResult.error("APPLY_FAIL", "团课报名失败");
    }

    /**
     * 根据教练id 日期查询 团课列表
     *
     * @param coachId
     * @param date
     * @return
     */
    @Override
    public PageResult listByCoachIdAndDate(Long coachId, String date) {
        return null;
    }
}
