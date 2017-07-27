package com.fitness.api.dao;

import com.fitness.api.domain.GroupClass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * 团课  -数据访问层
 * Created on 2017/7/23.
 */
@Repository
public interface GroupClassDao {

    /**
     * 创建团课
     *
     * @param groupClass
     * @return
     */
    Integer add(GroupClass groupClass);

    /**
     * 根据团课id 删除
     *
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 团课详情
     *
     * @param id
     * @return
     */
    GroupClass classInfo(Long id);

    /**
     * 修改团课
     *
     * @param groupClass
     * @return
     */
    Integer update(GroupClass groupClass);

    /**
     * 根据教练id  时间 检查有没有已存在的课程
     *
     * @param startDate
     * @param coachId
     * @return
     */
    Integer countByStartDate(@Param(value = "startDate") Date startDate, @Param(value = "coachId") Long coachId);

    /**
     * 团课报名
     *
     * @param memberId
     * @param id
     * @return
     */
    Integer apply(@Param(value = "memberId") Long memberId, @Param(value = "id") Long id);

    /**
     * 团课报名检查
     *
     * @param memberId
     * @param id
     * @return
     */
    Integer applyCount(@Param(value = "memberId") Long memberId, @Param(value = "id") Long id);

    /**
     * 根据场馆查询 团课列表数量
     *
     * @param stadiumId
     * @param date
     * @return
     */
    Integer groupClassCount(@Param(value = "stadiumId") Long stadiumId, @Param(value = "date") String date);


    /**
     * 根据场馆查询团课列表
     *
     * @param rowBounds
     * @param stadiumId
     * @param date
     * @return
     */
    List<GroupClass> groupClassList(RowBounds rowBounds, @Param(value = "stadiumId") Long stadiumId, @Param(value = "date") String date);

    /**
     * 团课数量
     * @param key
     * @return
     */
    Integer count(@Param(value = "key")String key);

    /**
     * 团课模糊查询 分页
     * @param rowBounds
     * @param key
     * @return
     */
    List<GroupClass> list(RowBounds rowBounds,@Param(value = "key")String key);

    /**
     * 根据教练id查询 团课详情
     * @param coachId
     * @return
     */
    GroupClass classInfoByCoachId(@Param(value = "coachId") Long coachId);
}
