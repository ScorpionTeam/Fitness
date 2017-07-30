package com.fitness.api.impl;

import com.fitness.api.dao.MealClassDao;
import com.fitness.api.service.MealClassService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 预约购餐 业务逻辑
 * Created on 2017/7/29.
 */
@Service
public class MealClassServiceImpl implements MealClassService {

    @Autowired
    private MealClassDao mealClassDao;

    /**
     * 预约并订餐
     *
     * @param memberId 会员id
     * @param classId  课程id
     * @param mealId   餐饮id
     * @param type     1团课 0私教
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult apply(Long memberId, Long classId, Long mealId, String type) {

        //检查是否预约过该课程
        Integer count = mealClassDao.validCount(classId, memberId);
        if (count > 0) {
            return BaseResult.error("APPLY_FAIL", "不可重复预约");
        }
        //预定课程
        Integer result = mealClassDao.apply(memberId, classId, type);

        //订餐
        Integer result1 = mealClassDao.applyMeal(memberId, mealId);

        //减少营养餐数量
        Integer result2 = mealClassDao.minusMealCount(mealId);

        if (result > 0 && result1 > 0 && result2 > 0)
            return BaseResult.success("约课并预定营养餐成功");
        return BaseResult.error("APPLY_FAIL", "约课并预定营养餐失败");

    }
}
