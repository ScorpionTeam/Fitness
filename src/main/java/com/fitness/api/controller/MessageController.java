package com.fitness.api.controller;

import com.fitness.api.domain.Message;
import com.fitness.api.service.MessageService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MessageService messageService;

    /**
     * 前台 消息列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize) {
        return messageService.list(pageNo, pageSize);
    }

    /**
     * 创建消息
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Message message) {
        return messageService.add(message);
    }

    /**
     * 根据消息id  查看消息详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/messageInfo", method = RequestMethod.GET)
    public BaseResult messageInfo(Long id) {
        return messageService.messageInfo(id);
    }

    /**
     * 后台消息列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/bcList", method = RequestMethod.GET)
    public PageResult bcList(Integer pageNo, Integer pageSize) {
        return messageService.bcList(pageNo, pageSize);
    }

    /**
     * 删除消息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return messageService.del(id);
    }

    /**
     * 修改
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Message message) {
        return messageService.update(message);
    }


}
