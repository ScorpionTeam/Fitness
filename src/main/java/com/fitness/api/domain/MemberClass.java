package com.fitness.api.domain;

import java.util.Date;

/**
 * 会员课程
 * Created on 2017/7/3.
 */
public class MemberClass {

    //主键
    private Long id;

    //课程id
    private Long classId;

    //会员id
    private Long memberId;

    //创建时间
    private Date createDate;

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

    @Override
    public String toString() {
        return "MemberClass{" +
                "id=" + id +
                ", classId=" + classId +
                ", memberId=" + memberId +
                ", createDate=" + createDate +
                '}';
    }
}
