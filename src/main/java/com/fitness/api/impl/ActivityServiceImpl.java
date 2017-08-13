package com.fitness.api.impl;

import com.fitness.api.dao.ActivityDao;
import com.fitness.api.domain.Activity;
import com.fitness.api.domain.Member;
import com.fitness.api.service.ActivityService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 活动-业务逻辑层
 * Created on 2017/7/1.
 */
@Service
public class ActivityServiceImpl implements ActivityService, PageService {

    @Autowired
    private ActivityDao activityDao;

    /**
     * 新增活动
     *
     * @param activity
     * @return
     */
    @Override
    public BaseResult add(Activity activity) {
        Integer result = activityDao.add(activity);
        if (result <= 0)
            return BaseResult.error("ADD_FAIL", "创建活动失败");
        return BaseResult.success("创建活动成功");

    }

    /**
     * 修改活动
     *
     * @param activity
     * @return
     */
    @Override
    public BaseResult update(Activity activity) {
        Integer result = activityDao.update(activity);
        if (result <= 0)
            return BaseResult.error("UPDATE_FAIL", "修改活动失败");
        return BaseResult.success("修改课程成功");

    }

    /**
     * 删除活动
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        Integer result = activityDao.del(id);
        if (result <= 0)
            return BaseResult.error("DELETE_FAIL", "删除活动失败");
        return BaseResult.success("删除活动成功");

    }

    /**
     * 活动列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {

        Integer count = activityDao.count();
        if (count <= 0)
            return new PageResult(null, 0);
        List<Activity> list = activityDao.list(rowBounds(pageNo, pageSize));
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据会员id查询我的活动  分页
     *
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */
    @Override
    public PageResult myActivity(Integer pageNo, Integer pageSize, Long memberId) {
        Integer count = activityDao.myActivityCount(memberId);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Activity> list = activityDao.myActivity(rowBounds(pageNo, pageSize), memberId);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据活动id 查看活动详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult activityInfo(Long id) {
        Activity activity = activityDao.activityInfo(id);
        if (null == activity)
            return BaseResult.nonSuchResult();

        //新增访问量
        activityDao.visitAdd(id);

        //根据活动id查询 参加互动的会员列表
        List<Member> memberList = activityDao.getByActivityId(id);
        if (null != memberList && memberList.size() > 0) {
            activity.setMemberList(memberList);
        }
        return BaseResult.success(activity);
    }

    /**
     * 根据场馆id  查询往期活动  分页
     *
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */
    @Override
    public PageResult pastActivity(Integer pageNo, Integer pageSize, Long stadiumId) {
        Integer count = activityDao.pastActivityCount(stadiumId);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Activity> list = activityDao.pastActivity(rowBounds(pageNo, pageSize), stadiumId);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据场馆id 查询最新活动 分页
     *
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */
    @Override
    public PageResult newActivity(Integer pageNo, Integer pageSize, Long stadiumId) {
        Integer count = activityDao.newActivityCount(stadiumId);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Activity> list = activityDao.newActivity(rowBounds(pageNo, pageSize), stadiumId);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据活动id查看 最新活动
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult visitNewest(Long id) {
        Activity activity = activityDao.activityInfo(id);
        if (null == activity)
            return BaseResult.nonSuchResult();

        //阅读次数+1
        activityDao.visitAdd(id);
        return BaseResult.success(activity);
    }

    /**
     * 参加活动
     *
     * @param memberId
     * @param activityId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult apply(Long memberId, Long activityId) {

        //检查是否已参加该活动
        Integer count = activityDao.checkIsApply(memberId, activityId);
        if (count > 0)
            return BaseResult.error("NOT_APPLY", "已报名该活动,不可重复报名");
        activityDao.applyActivity(memberId, activityId);
        //修改活动报名人数
        activityDao.updateActivityApplyTotal(activityId);
        return BaseResult.success("活动报名成功");
    }

    /**
     * 首页活动展示
     *
     * @return
     */
    @Override
    public BaseResult home() {
        List<Activity> activityList = activityDao.activityForHome();
        return BaseResult.success(activityList);
    }
}
