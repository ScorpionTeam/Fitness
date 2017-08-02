package com.fitness.api.impl;

import com.fitness.api.dao.QADao;
import com.fitness.api.domain.QA;
import com.fitness.api.service.QAService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/8/2.
 */
@Service
public class QAServiceImpl implements QAService, PageService {


    @Autowired
    private QADao qaDao;

    /**
     * 发布问答
     *
     * @param qa
     * @return
     */
    @Override
    public BaseResult publish(QA qa) {
        return null;
    }

    /**
     * 问答列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {
        return null;
    }

    /**
     * 后台问答列表
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult bacList(Integer pageNo, Integer pageSize, String key) {
        return null;
    }

    /**
     * 删除问答
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }


}
