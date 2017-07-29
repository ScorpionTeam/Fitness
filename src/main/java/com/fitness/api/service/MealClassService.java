package com.fitness.api.service;

import com.fitness.api.domain.MealClass;
import com.fitness.result.BaseResult;

/**
 * Created on 2017/7/29.
 */
public interface MealClassService {

    /**
     * 预约并购餐
     * @param mealClass
     * @return
     */
    BaseResult apply(MealClass mealClass);
}
