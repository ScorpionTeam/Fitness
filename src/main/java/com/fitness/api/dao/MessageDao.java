package com.fitness.api.dao;

import com.fitness.api.domain.Message;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/8/14.
 */
@Repository
public interface MessageDao {

    /**
     * 用户端消息列表
     * @param rowBounds
     * @return
     */
    List<Message> list(RowBounds rowBounds);

    /**
     * 用户端消息数量
     * @return
     */
    Integer count();

    /**
     * 创建消息
     * @param message
     * @return
     */
    Integer add(Message message);

    /**
     * 消息详情
     * @param id
     * @return
     */
    Message messageInfo(Long id);

    /**
     * 修改
     * @param message
     * @return
     */
    Integer update(Message message);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 修改为已读
     * @param id
     * @return
     */
    Integer updateStatus(Long id);

    /**
     * 未读消息
     * @return
     */
    Integer unRead();
}
