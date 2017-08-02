package com.fitness.api.dao;

import com.fitness.api.domain.QA;
import com.fitness.result.BaseResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/8/2.
 */
@Repository
public interface QADao {


    /**
     * 发布问题
     *
     * @param qa
     * @return
     */
    Integer publish(QA qa);

    /**
     * 问答数量
     *
     * @return
     */
    Integer count();

    /**
     * 问答列表
     *
     * @param rowBounds
     * @return
     */
    List<QA> list(RowBounds rowBounds);

    /**
     * 回答问题
     *
     * @param qa
     * @return
     */
    Integer answer(QA qa);

    /**
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 问答数量
     * @param key
     * @return
     */
    Integer bcCount(@Param(value = "key") String key);

    /**
     * 问答列表
     * @param rowBounds
     * @param key
     * @return
     */
    List<QA> bcList(RowBounds rowBounds,@Param(value = "key")String key);


}
