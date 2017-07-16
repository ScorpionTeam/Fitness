package com.fitness.api.dao;

import com.fitness.api.domain.Remark;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by THINK on 2017/7/8.
 */
@Repository
public interface RemarkDao {

    /**
     *  新增会员对教练评分
     * @param remark 评分实体类
     * @return
     */
    int insertRemark(Remark remark);

    /**
     *  获取某位教练评分总数
     */
    int getScoreSum(Long coachId);

    /**
     * 获取某位教练评分总条数
     * @param coachId
     * @return
     */
    int getScoreCount(Long coachId);

    /**
     * 获取某位教练的评论次数最多的前三条印象
     * @param coachId
     * @return
     */
    List<String> getImpression(Long coachId);
}
