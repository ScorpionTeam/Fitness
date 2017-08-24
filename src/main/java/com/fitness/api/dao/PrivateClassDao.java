package com.fitness.api.dao;

import com.fitness.api.domain.Coach;
import com.fitness.api.domain.MemberClassExt;
import com.fitness.api.domain.PrivateClass;
import com.fitness.api.domain.PrivateClassTime;
import com.fitness.api.dto.PrivateClassDTO;
import com.sun.rowset.internal.Row;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 私教课数据访问层
 * Created on 2017/7/1.
 */
@Repository
public interface PrivateClassDao {

    /**
     * 新增私教课程
     *
     * @param privateClass
     * @return
     */
    int insertPrivateClass(PrivateClass privateClass);

    /**
     * 根据id删除私教课
     *
     * @param id
     * @return
     */
    int del(Long id);

    /**
     * 修改教练开课状态
     *
     * @param coach
     * @return
     */
    int updateCoachStatus(Coach coach);

    /**
     * 修改私教课
     *
     * @param privateClass
     * @return
     */
    int updatePrivateClass(PrivateClass privateClass);

    /**
     * 根据教练id 查询课程列表数量
     *
     * @param coachId
     * @return
     */
    Integer listByCoachIdCount(@Param(value = "coachId") Long coachId,@Param(value = "date")String date);

    /**
     * 根据教练id 查询课程列表
     *
     * @param rowBounds
     * @param coachId
     * @param date
     * @return
     */
    List<PrivateClass> listByCoachId(RowBounds rowBounds, @Param(value = "coachId") Long coachId,@Param(value = "date") String date);

    /**
     * 创建私教数据
     *
     * @param classId
     * @param memberId
     * @return
     */
    Integer insertPrivateClassParam(@Param(value = "classId") Long classId, @Param(value = "memberId") Long memberId);

    /**
     * 私教数量
     * @return
     */
    Integer bcCount();

    /**
     * 私教列表
     * @param rowBounds
     * @return
     */
    List<PrivateClass> bcList(RowBounds rowBounds);

    /**
     * 课程详情
     * @param id
     * @return
     */
    PrivateClass classInfo(Long id);


    /**
     * 根据日期、会员id 查询 私教课日程
     * @param rowBounds
     * @param date
     * @param memberId
     * @return
     */
    List<MemberClassExt> schedulePrivateClass(RowBounds rowBounds,@Param(value = "date")String date,@Param(value = "memberId")Long memberId);

    /**
     * 根据日期、会员id查询 私教课日程数量
     * @param date
     * @param memberId
     * @return
     */
    Integer schedulePrivateClassCount(@Param(value = "date")String date,@Param(value = "memberId")Long memberId);
}
