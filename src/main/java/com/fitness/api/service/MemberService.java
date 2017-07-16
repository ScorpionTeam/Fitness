package com.fitness.api.service;

import com.fitness.api.domain.Member;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 会员 业务逻辑接口
 * Created on 2017/7/1.
 */
public interface MemberService {

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    BaseResult login(String phone, String password) throws Exception;

    /**
     * 注册
     *
     * @param member
     * @return
     */
    BaseResult register(Member member) throws Exception;

    /**
     * 退出
     *
     * @param id
     * @return
     */
    BaseResult logout(Long id);

    /**
     * 修改会员信息
     * @param member
     * @return
     */
    BaseResult update(Member member);

    /**
     * 昵称修改
     *
     * @param id
     * @param nick
     * @return
     */
    BaseResult updateNick(Long id, String nick);

    /**
     * 绑定会员卡
     * @param member
     * @return
     */
    BaseResult bindCard(Member member);

    /**
     * 根据会员id  查询会员详情
     * @param id
     * @return
     */
    BaseResult memberInfo(Long id);

    /**
     * 根据会员id  注销
     * @param id
     * @return
     */
    BaseResult cancel(Long id);

    /**
     * 根据会员手机号查找 列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);

}
