package com.fitness.api.controller;

import com.fitness.api.domain.QA;
import com.fitness.api.service.QAService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问答
 * Created on 2017/8/2.
 */
@RestController
@RequestMapping(value = "/qa")
public class QAController {

    @Autowired
    private QAService qaService;

    /**
     * 问答列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize) {
        return qaService.list(pageNo, pageSize);
    }

    /**
     * 发布问题
     *
     * @return
     */
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public BaseResult publish(@RequestBody QA qa) {
        return qaService.publish(qa);
    }

    /**
     * 回答问题
     *
     * @param qa
     * @return
     */
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public BaseResult answer(@RequestBody QA qa) {
        return qaService.answer(qa);
    }

    /**
     * 删除问题
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return qaService.del(id);
    }

    /**
     * 问答列表
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @RequestMapping(value = "/bacList", method = RequestMethod.GET)
    public PageResult bacList(Integer pageNo, Integer pageSize, String key) {
        return qaService.bacList(pageNo, pageSize, key);
    }

    /**
     * 我的问答
     *
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/myQuestion", method = RequestMethod.GET)
    public PageResult myQuestion(Integer pageNo, Integer pageSize, Long memberId) {
        return qaService.myQuestion(pageNo, pageSize, memberId);
    }


}
