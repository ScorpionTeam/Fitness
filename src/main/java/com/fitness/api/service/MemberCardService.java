package com.fitness.api.service;

import com.fitness.api.domain.MemberCard;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 会员卡业务逻辑接口
 * Created on 2017/7/2.
 */
public interface MemberCardService {

    /**
     * 创建会员卡
     * @param memberCard
     * @return
     */
    BaseResult add(MemberCard memberCard);

    /**
     * 修改会员卡
     * @param memberCard
     * @return
     */
    BaseResult update(MemberCard memberCard);

    /**
     * 根据会员卡id  删除会员卡
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 根据会员卡号 查询会员卡列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);

    /**
     * 根据会员卡id 查看会员卡详情
     * @param id
     * @return
     */
    BaseResult memberCardInfo(Long id);

    /**
     * 根据场馆id 查询会员卡列表
     * @param stadiumId
     * @return
     */
    BaseResult cardList(Long stadiumId);
}
