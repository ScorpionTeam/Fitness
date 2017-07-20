package com.fitness.api.service;

import com.fitness.api.domain.Activity;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 活动接口
 * Created on 2017/7/1.
 */
public interface ActivityService {

    /**
     * 新增 活动
     * @param activity
     * @return
     */
    BaseResult add(Activity activity);

    /**
     * 修改活动
     * @param activity
     * @return
     */
    BaseResult update(Activity activity);

    /**
     * 删除活动
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 根据场馆查询活动列表  根据关键字搜索  分页
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,Long stadiumId,String key);

    /**
     * 根据会员id查询我的活动  分页
     * @param memberId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult myActivity(Integer pageNo,Integer pageSize,Long memberId);

    /**
     * 根据活动id查询活动详情
     * @param id
     * @return
     */
    BaseResult activityInfo(Long id);

    /**
     * 根据场馆id 查询往期活动  分页
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */
    PageResult pastActivity(Integer pageNo,Integer pageSize,Long stadiumId);

    /**
     * 根据场馆id 查询最新活动 分页
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */
    PageResult newActivity(Integer pageNo,Integer pageSize,Long stadiumId);

    /**
     * 根据id 查询最新活动
     * @param id
     * @return
     */
    BaseResult visitNewest(Long id);

    /**
     * 参加活动
     * @param memberId
     * @param activityId
     * @return
     */
    BaseResult apply(Long memberId,Long activityId);
}
