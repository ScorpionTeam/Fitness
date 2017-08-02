package com.fitness.api.impl;

import com.fitness.api.dao.QADao;
import com.fitness.api.domain.QA;
import com.fitness.api.service.QAService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Integer result = qaDao.publish(qa);
        if (result > 0)
            return BaseResult.success("问题发布成功");
        return BaseResult.error("PUBLISH_FAIL", "问题发布失败");
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

        Integer count = qaDao.count();
        if (count <= 0)
            return new PageResult(null, 0);
        List<QA> list = qaDao.list(rowBounds(pageNo, pageSize));
        return new PageResult(list, count, pageNo, pageSize);
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

    /**
     * 回答问题
     *
     * @param qa
     * @return
     */
    @Override
    public BaseResult answer(QA qa) {
        Integer result = qaDao.answer(qa);
        if (result > 0)
            return BaseResult.success("回答成功");
        return BaseResult.error("ANSWER_FAIL", "回答失败");
    }


}
