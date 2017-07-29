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
    Integer add(Impression impression);

    /**
     * 根据教练id查询印象列表
     * @param coachId
     * @return
     */
    List<Impression> list(@Param(value = "coachId") Long coachId);


}
