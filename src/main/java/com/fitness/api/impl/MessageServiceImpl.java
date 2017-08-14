package com.fitness.api.impl;

import com.fitness.api.dao.MessageDao;
import com.fitness.api.domain.Message;
import com.fitness.api.service.MessageService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/8/14.
 */
@Service
public class MessageServiceImpl implements MessageService, PageService {


    @Autowired
    private MessageDao messageDao;

    /**
     * 用户端 消息列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {

        Integer count = messageDao.count();
        if (count == 0)
            return new PageResult(null, 0);
        List<Message> list = messageDao.list(rowBounds(pageNo, pageSize));

        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 创建消息
     *
     * @param message
     * @return
     */
    @Override
    public BaseResult add(Message message) {

        Integer result = messageDao.add(message);
        if (result == 0)
            return BaseResult.error("ADD_FAIL", "创建消息失败");
        return BaseResult.success("创建消息成功");
    }

    /**
     * 消息详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult messageInfo(Long id) {
        messageDao.updateStatus(id);
        Message message = messageDao.messageInfo(id);
        return BaseResult.success(message);
    }

    /**
     * 后台消息列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult bcList(Integer pageNo, Integer pageSize) {
        return null;
    }

    /**
     * 修改
     *
     * @param message
     * @return
     */
    @Override
    public BaseResult update(Message message) {
        return null;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 未读消息
     * @return
     */
    @Override
    public BaseResult unRead() {
        Integer count = messageDao.unRead();
        return BaseResult.success(count);
    }
}
