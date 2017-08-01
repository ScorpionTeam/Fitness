package com.fitness.api.domain;

import java.util.Date;

/**
 * 评分
 * Created on 2017/7/27.
 */
public class Grade {

    //主键
    private Long id;

    //会员id
    private Long memberId;

    //课程id
    private Long classId;

    //教练id
    private Long coachId;

    //服务评分
    private Integer serviceScore;

    //教练评分
    private Integer coachScore;

    //课程评分
    private Integer classScore;

    //创建时间
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Integer getServiceScore() {
        return serviceScore == null ? 0 : serviceScore;
    }

    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    public Integer getCoachScore() {
        return coachScore == null ? 0 : coachScore;
    }

    public void setCoachScore(Integer coachScore) {
        this.coachScore = coachScore;
    }

    public Integer getClassScore() {
        return classScore == null ? 0 : classScore;
    }

    public void setClassScore(Integer classScore) {
        this.classScore = classScore;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", classId=" + classId +
                ", coachId=" + coachId +
                ", serviceScore=" + serviceScore +
                ", coachScore=" + coachScore +
                ", classScore=" + classScore +
                ", createDate=" + createDate +
                '}';
    }
}
