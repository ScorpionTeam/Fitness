package com.fitness.api.impl;

import com.fitness.api.domain.Message;
import com.fitness.api.service.MessageService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/8/14.
 */
@Service
public class MessageServiceImpl implements MessageService {

    /**
     * 用户端 消息列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {
        return null;
    }

    /**
     * 创建消息
     * @param message
     * @return
     */
    @Override
    public BaseResult add(Message message) {
        return null;
    }

    /**
     * 消息详情
     * @param id
     * @return
     */
    @Override
    public BaseResult messageInfo(Long id) {
        return null;
    }

    /**
     * 后台消息列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult bcList(Integer pageNo, Integer pageSize) {
        return null;
    }
}
