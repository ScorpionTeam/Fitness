package com.fitness.api.controller;

import com.fitness.api.domain.Message;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息模块
 * Created on 2017/8/14.
 */
@RestController
@RequestMapping("message")
public class MessageController {

    /**
     * 前台 消息列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize) {
        return null;
    }

    /**
     * 创建消息
     * @param message
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Message message) {
        return null;
    }

    /**
     * 根据消息id  查看消息详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/messageInfo",method = RequestMethod.GET)
    public BaseResult messageInfo(Long id){
        return null;
    }

    /**
     * 后台消息列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/bcList",method = RequestMethod.GET)
    public PageResult bcList(Integer pageNo,Integer pageSize){
        return null;
    }


}
