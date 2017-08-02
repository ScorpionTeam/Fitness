package com.fitness.api.controller;

import com.fitness.api.domain.QA;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
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


    /**
     * 问答列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize) {

        return null;
    }

    /**
     * 发布问题
     *
     * @return
     */
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public BaseResult publish(@RequestBody QA qa) {
        return null;
    }

    /**
     * 回答问题
     * @param qa
     * @return
     */
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public BaseResult answer(@RequestBody QA qa) {
        return null;
    }

    /**
     * 删除问题
     * @param id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public BaseResult del(Long id){
        return null;
    }

    /**
     * 问答列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @RequestMapping(value = "/bacList",method = RequestMethod.GET)
    public PageResult bacList(Integer pageNo,Integer pageSize,String key){
        return null;
    }


}
