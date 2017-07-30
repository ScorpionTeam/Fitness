package com.fitness.api.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created on 2017/7/30.
 */
@Repository
public interface MealClassDao {

    /**
     * 约课
     *
     * @param memberId 会员id
     * @param classId  课程id
     * @param type     类型 1团课 0私教
     * @return
     */
    Integer apply(@Param(value = "memberId") Long memberId,
                  @Param(value = "classId") Long classId,
                  @Param(value = "type") String type);

    /**
     * 预定营养餐
     * @param memberId
     * @param mealId
     * @return
     */
    Integer applyMeal(@Param(value = "memberId") Long memberId,
                      @Param(value = "mealId") Long mealId);


    /**
     * 减少营养餐数量
     * @param mealId
     * @return
     */
    Integer minusMealCount(@Param(value = "mealId") Long mealId);

    /**
     * 校验是否已预定课程
     * @param classId
     * @param memberId
     * @return
     */
    Integer validCount(@Param(value = "classId")Long classId,
                       @Param(value = "memberId")Long memberId);
}
