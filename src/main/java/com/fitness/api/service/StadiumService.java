package com.fitness.api.service;

import com.fitness.api.domain.Stadium;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 场馆业务逻辑接口
 * Created on 2017/7/3.
 */
public interface StadiumService {

    /**
     * 创建场馆
     * @param stadium
     * @return
     */
    BaseResult add(Stadium stadium);

    /**
     * 根据场馆id 删除场馆
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 根据场馆名称模糊查询  分页
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);

    /**
     * 修改场馆信息
     * @param stadium
     * @return
     */
    BaseResult update(Stadium stadium);

    /**
     * 根据场馆id 查询场馆详情
     * @param id
     * @return
     */
    BaseResult stadiumInfo(Long id);

    /**
     * 查询所有可用场馆列表
     * @return
     */
    BaseResult allStadium();


}
