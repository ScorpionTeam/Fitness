package com.fitness.api.service;

import com.fitness.api.domain.Meal;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 餐饮 业务逻辑接口
 * Created on 2017/7/29.
 */
public interface MealService {

    /**
     * 新增餐饮
     * @param meal
     * @return
     */
    BaseResult add(Meal meal);

    /**
     * 餐饮列表分页
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);
}
