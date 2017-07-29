package com.fitness.api.domain;

/**
 * Created on 2017/7/29.
 */
public class MealClass {

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 课程id
     */
    private Long classId;

    /**
     * 餐饮id
     */
    private Long mealId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    @Override
    public String toString() {
        return "MealClass{" +
                "memberId=" + memberId +
                ", classId=" + classId +
                ", mealId=" + mealId +
                '}';
    }
}
