package com.fitness.api.service;

import com.fitness.api.domain.Remark;
import com.fitness.result.BaseResult;

/**
 * Created by THINK on 2017/7/8.
 */
public interface RemarkService {

    /**
     * 新增评分
     * @param remark
     * @return
     */
    BaseResult insertRemark(Remark remark);

    /**
     * 获取某位教练的综合评分
     * @param coachId
     * @return
     */
    BaseResult getCoachScoreById(Long coachId);

    /**
     * 获取某位教练的评论次数最多的前三条印象
     * @param coachId
     * @return
     */
    BaseResult getImpression(Long coachId);
}
