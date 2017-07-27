package com.fitness.api.dao;

import com.fitness.api.domain.ClassGrade;

/**
 * 评分数据访问层
 * Created on 2017/7/27.
 */
public interface ClassGradeDao {

    /**
     * 根据教练id查询 评分
     * @param coachId
     * @return
     */
    ClassGrade getScoreByCoachId(Long coachId);

    /**
     * 根据课程id查询评分
     * @param classId
     * @return
     */
    ClassGrade getScoreByClassId(Long classId);

    /**
     * 创建评分数据
     * @param classGrade
     * @return
     */
    Integer add(ClassGrade classGrade);
}
