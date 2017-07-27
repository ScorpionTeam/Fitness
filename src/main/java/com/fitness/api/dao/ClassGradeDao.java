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
    ClassGrade getScore(Long coachId);
}
