package com.fitness.api.service;

import com.fitness.api.domain.QA;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * Created on 2017/8/2.
 */
public interface QAService {

    /**
     * 发布问题
     * @param qa
     * @return
     */
    BaseResult publish(QA qa);

    /**
     * 问答列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize);

    /**
     * 后台问答列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult bacList(Integer pageNo,Integer pageSize,String key);

    /**
     * 删除问答
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 回答问题
     * @param qa
     * @return
     */
    BaseResult answer(QA qa);

    /**
     * 我的问答
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */
    PageResult myQuestion(Integer pageNo,Integer pageSize,Long memberId);

    /**
     * 问答修改
     * @param qa
     * @return
     */
    BaseResult update(QA qa);


}
