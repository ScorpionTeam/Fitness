package com.fitness.api.domain;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 会员课程
 * Created on 2017/7/3.
 */
public class MemberClass {

    /**
     * 主键
     */
    private Long id;

    /**
     * 课程id
     */
    private Long classId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 状态 1 已报名  2 已签到  3 未签到
     */
    private String status;

    /**
     * 类型 1 团课 0 私教
     */
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MemberClass{" +
                "id=" + id +
                ", classId=" + classId +
                ", memberId=" + memberId +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
