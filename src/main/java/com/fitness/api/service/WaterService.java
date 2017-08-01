package com.fitness.api.service;

import com.fitness.api.domain.Water;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * Created on 2017/8/1.
 */
public interface WaterService {

    /**
     * 创建
     * @param water
     * @return
     */
    BaseResult add(Water water);

    /**
     * 删除
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 修改
     * @param water
     * @return
     */
    BaseResult update(Water water);

    /**
     * 列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);
}
