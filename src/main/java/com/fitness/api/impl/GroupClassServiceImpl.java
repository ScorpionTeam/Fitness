package com.fitness.api.impl;

import com.fitness.api.dao.GroupClassDao;
import com.fitness.api.domain.GroupClass;
import com.fitness.api.service.GroupClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 团课-业务逻辑
 * Created on 2017/7/23.
 */
@Service
public class GroupClassServiceImpl implements GroupClassService {

    @Autowired
    private GroupClassDao groupClassDao;


    /**
     * 创建团课
     *
     * @param groupClass
     * @return
     */
    @Override
    public BaseResult add(GroupClass groupClass) {
        Integer count = groupClassDao.countByStartDate(groupClass.getStartDate());

        if (count > 0)
            return BaseResult.error("EXIST", "该时间段已存在");
        Integer result = groupClassDao.add(groupClass);
        if (result > 0)
            return BaseResult.success("创建团课成功");
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
        return BaseResult.error("ADD_FAIL", "修改团课失败");
    }

    /**
     * 根据团课id删除
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 团课详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult classInfo(Long id) {
        return null;
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
        return null;
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
