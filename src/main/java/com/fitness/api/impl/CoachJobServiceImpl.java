package com.fitness.api.impl;

import com.fitness.api.dao.CoachJobDao;
import com.fitness.api.domain.CoachJob;
import com.fitness.api.service.CoachJobService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工作经历业务逻辑
 * Created on 2017/7/2.
 */
@Service
public class CoachJobServiceImpl implements CoachJobService,PageService {

    @Autowired
    private CoachJobDao coachJobDao;


    /**
     *  新增工作经历
     * @param coachJob
     * @return
     */
    @Override
    public BaseResult add(CoachJob coachJob) {
        return null;
    }

    /**
     * 更新工作经历
     * @param coachJob
     * @return
     */
    @Override
    public BaseResult updateCoachJob(CoachJob coachJob) {
        return null;
    }

    /**
     * 删除工作经历
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 工作经历
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return null;
    }
}
