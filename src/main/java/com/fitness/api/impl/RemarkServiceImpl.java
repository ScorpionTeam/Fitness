package com.fitness.api.impl;

import com.fitness.api.dao.RemarkDao;
import com.fitness.api.domain.Remark;
import com.fitness.api.service.RemarkService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@Service
public class RemarkServiceImpl implements RemarkService{

    @Autowired
    private RemarkDao remarkDao;

    @Override
    public BaseResult insertRemark(Remark remark) {
        int i = remarkDao.insertRemark(remark);
        if(i<=0)
            return BaseResult.error("ADD_FAIL","新增评分失败");
        return BaseResult.success("新增评分成功");
    }

    @Override
    public BaseResult getCoachScoreById(Long coachId) {
        int count = remarkDao.getScoreCount(coachId);
        int sum = remarkDao.getScoreSum(coachId);
        int average = sum/count;
        return BaseResult.success(average);
    }

    @Override
    public BaseResult getImpression(Long coachId) {
        List<String> list = remarkDao.getImpression(coachId);
        return BaseResult.success(list);
    }
}
