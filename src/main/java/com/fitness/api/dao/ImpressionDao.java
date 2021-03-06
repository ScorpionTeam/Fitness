package com.fitness.api.dao;

import com.fitness.api.domain.Impression;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/7/29.
 */
@Repository
public interface ImpressionDao {

    /**
     * 创建印象
     * @param impression
     * @return
     */
    Integer add(List<Impression> impression);

    /**
     * 根据教练id查询印象列表
     * @param coachId
     * @return
     */
    List<Impression> list(@Param(value = "coachId") Long coachId);

    /**
     * 根据教练id统计印象最多的   查询4条  作为擅长类型
     * @param coachId
     * @return
     */
    List<String> goodAtLst(@Param(value = "coachId") Long coachId);

    /**
     * 创建印象
     * @param impression
     * @return
     */
    Integer addImpression(Impression impression);

    /**
     * 修改印象
     * @param impression
     * @return
     */
    Integer update(Impression impression);

    /**
     * 删除印象
     * @param id
     * @return
     */
    Integer del(Long id);


}
