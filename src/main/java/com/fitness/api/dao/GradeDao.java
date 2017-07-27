package com.fitness.api.dao;

import com.fitness.api.domain.Grade;

/**
 * 评分数据访问层
 * Created on 2017/7/27.
 */
public interface GradeDao {

    /**
     * 根据教练id查询 评分
     * @param coachId
     * @return
     */
    Grade getScoreByCoachId(Long coachId);

    /**
     * 根据课程id查询评分
     * @param classId
     * @return
     */
    Grade getScoreByClassId(Long classId);

    /**
     * 创建评分数据
     * @param classGrade
     * @return
     */
    Integer add(Grade classGrade);
}
