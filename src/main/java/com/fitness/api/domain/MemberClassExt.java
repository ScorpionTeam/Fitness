package com.fitness.api.domain;

import java.util.Date;

/**
 * Created on 2017/8/23.
 */
public class MemberClassExt {

    //课程id
    private Long id;

    //开课时间
    private Date date;

    //课程类型
    private String type;

    //课程状态
    private String status;

    //会员id
    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberClassExt{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
