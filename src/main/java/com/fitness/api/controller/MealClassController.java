package com.fitness.api.controller;

import com.fitness.result.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预约-订餐-api
 * Created on 2017/7/29.
 */
@RestController
@RequestMapping("mealClass")
public class MealClassController {

    /**
     * 预约并订餐
     *
     * @param memberId 会员id
     * @param classId  课程id
     * @param mealId   餐饮id
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public BaseResult apply(Long memberId, Long classId, Long mealId) {
        return null;
    }


}
