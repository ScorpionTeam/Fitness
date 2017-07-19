package com.fitness.api.domain;

import java.util.Date;

/**
 *
 * 私教课  时间段
 * Created on 2017/7/19.
 */
public class PrivateClassTime {

    //主键
    private Long id;

    //私教课id
    private Long privateClassId;

    //时间段
    private String times;

    //开始时间
    private Date startDate;

    //状态  1已定   0 空闲
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrivateClassId() {
        return privateClassId;
    }

    public void setPrivateClassId(Long privateClassId) {
        this.privateClassId = privateClassId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PrivateClassTime{" +
                "id=" + id +
                ", privateClassId=" + privateClassId +
                ", times='" + times + '\'' +
                ", startDate=" + startDate +
                ", status='" + status + '\'' +
                '}';
    }
}
