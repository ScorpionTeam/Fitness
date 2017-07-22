package com.fitness.api.dao;

import com.fitness.api.domain.Activity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 活动数据访问层
 * Created on 2017/7/1.
 */
@Repository
public interface ActivityDao {

    /**
     * 创建活动
     * @param activity
     * @return
     */
    Integer add(Activity activity);

    /**
     * 修改活动
     * @param activity
     * @return
     */
    Integer update(Activity activity);

    /**
     * 根据活动id删除活动
     * @param id
     * @return
     */
    Integer del(@Param(value = "id") Long id);

    /**
     * 活动列表
     * @param rowBounds
     * @return
     */
    List<Activity> list(RowBounds rowBounds);

    /**
     * 列表数量
     * @return
     */
    Integer count();
    /**
     * 根据会员id查询我的活动  分页
     * @param rowBounds
     * @param memberId
     * @return
     */
    List<Activity> myActivity(RowBounds rowBounds,@Param(value = "memberId") Long memberId);

    /**
     * 根据会员id查询我的活动数量
     * @param memberId
     * @return
     */
    Integer myActivityCount(@Param(value = "memberId") Long memberId);
    /**
     * 根据场馆id 查询最新活动  分页
     * @param rowBounds
     * @param stadiumId
     * @return
     */
    List<Activity> newActivity(RowBounds rowBounds,@Param(value = "stadiumId") Long stadiumId);

    /**
     * 根据场馆id 查询最新活动数量
     * @param stadiumId
     * @return
     */
    Integer newActivityCount(@Param(value = "stadiumId") Long stadiumId);
    /**
     * 根据场馆id 查询最近活动 分页
     * @param rowBounds
     * @param stadiumId
     * @return
     */
    List<Activity> pastActivity(RowBounds rowBounds,@Param(value = "stadiumId") Long stadiumId);

    /**
     * 根据场馆id 查询往期活动数量
     * @param stadiumId
     * @return
     */
    Integer pastActivityCount(@Param(value = "stadiumId") Long stadiumId);

    /**
     * 根据活动id  查看活动详情
     * @param id
     * @return
     */
    Activity activityInfo(@Param(value = "id") Long id);

    /**
     * 阅读次数+1
     * @param id
     */
    void visitAdd(@Param(value = "id") Long id);

    /**
     * 参加活动
     * @param memberId
     * @param activityId
     * @return
     */
    Integer applyActivity(@Param(value = "memberId")Long memberId,@Param(value = "activityId")Long activityId);

}
