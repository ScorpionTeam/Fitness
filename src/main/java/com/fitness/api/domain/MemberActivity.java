package com.fitness.api.domain;

/**
 *
 * 会员-活动 关系
 * Created on 2017/7/20.
 */
public class MemberActivity {

    //主键
    private Long id;

    //会员id
    private Long memberId;

    //活动id
    private Long activityId;

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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }


    @Override
    public String toString() {
        return "MemberActivity{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", activityId=" + activityId +
                '}';
    }
}
