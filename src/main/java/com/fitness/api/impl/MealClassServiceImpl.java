package com.fitness.api.impl;

import com.fitness.api.service.MealClassService;
import com.fitness.result.BaseResult;
import org.springframework.stereotype.Service;

/**
 * 预约购餐 业务逻辑
 * Created on 2017/7/29.
 */
@Service
public class MealClassServiceImpl implements MealClassService {


    /**
     * 预约并订餐
     *
     * @param memberId 会员id
     * @param classId  课程id
     * @param mealId   餐饮id
     * @return
     */
    @Override
    public BaseResult apply(Long memberId, Long classId, Long mealId) {

        //预定课程

        //订餐

        return null;
    }
}
