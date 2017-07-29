package com.fitness.api.domain;

import java.util.Date;

/**
 * Created on 2017/7/29.
 */
public class MemberMeal {

    /**
     * 主键
     */
    private Long id;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 餐饮id
     */
    private Long mealId;

    /**
     * 创建时间
     */
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "MemberMeal{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", mealId=" + mealId +
                ", createDate=" + createDate +
                '}';
    }
}
