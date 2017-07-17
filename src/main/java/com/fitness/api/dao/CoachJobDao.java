package com.fitness.api.dao;

import com.fitness.api.domain.CoachJob;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 工作经历数据访问层
 * Created on 2017/7/2.
 */
@Repository
public interface CoachJobDao {

    /**
     * 根据教练id查询 工作经历列表
     * @param coachId
     * @return
     */
    List<CoachJob> coachJobList(@Param(value = "coachId") Long coachId);
}
