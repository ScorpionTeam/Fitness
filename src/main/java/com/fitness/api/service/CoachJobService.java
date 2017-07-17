package com.fitness.api.service;

import com.fitness.api.domain.CoachJob;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 工作经历 业务逻辑接口
 * Created on 2017/7/2.
 */
public interface CoachJobService {

    /**
     * 新增工作经历
     *
     * @param coachJob
     * @return
     */
    BaseResult add(CoachJob coachJob);

    /**
     * 修改工作经历
     *
     * @param coachJob
     * @return
     */
    BaseResult updateCoachJob(CoachJob coachJob);

    /**
     * 根据id删除工作经历
     *
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 工作经历列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, String key);

}
