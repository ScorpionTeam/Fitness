package com.fitness.api.service;

import com.fitness.api.domain.Message;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * Created on 2017/8/14.
 */
public interface MessageService {

    /**
     * 前台消息列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize);

    /**
     * 创建消息
     *
     * @param message
     * @return
     */
    BaseResult add(Message message);

    /**
     * 消息详情
     *
     * @param id
     * @return
     */
    BaseResult messageInfo(Long id);


    /**
     * 后台消息列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult bcList(Integer pageNo, Integer pageSize);

    /**
     * 修改
     * @param message
     * @return
     */
    BaseResult update(Message message);

    /**
     * 删除
     * @param id
     * @return
     */
    BaseResult del(Long id);

}
