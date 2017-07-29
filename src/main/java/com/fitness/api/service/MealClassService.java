package com.fitness.api.service;

import com.fitness.result.BaseResult;

/**
 * Created on 2017/7/29.
 */
public interface MealClassService {

    /**
     * 预约并订餐
     * @param memberId  会员id
     * @param classId   课程id
     * @param mealId    餐饮id
     * @return
     */
    BaseResult apply(Long memberId,Long classId,Long mealId);

}
