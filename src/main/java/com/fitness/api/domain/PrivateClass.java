package com.fitness.api.domain;


import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

/**
 * 私教课
 * Created on 2017/7/1.
 */
public class PrivateClass {

    //主键
    private Long id;

    //课程名称
    private String name;

    //课程时长
    private Integer classTime;

    //课程描述
    private String classDesc;

    //教练id
    private Long coachId;

    //创建时间
    private Date createDate;

    //修改时间
    private Date updateDate;

    //课程状态 1空闲 0 已预订
    private String status;

    //开始时间
    private Date startDate;

    @Transient
    //课程图片集合
    private List<Img> imgList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassTime() {
        return classTime;
    }

    public void setClassTime(Integer classTime) {
        this.classTime = classTime;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Img> getImgList() {
        return imgList;
    }

    public void setImgList(List<Img> imgList) {
        this.imgList = imgList;
    }

    @Override
    public String toString() {
        return "PrivateClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classTime=" + classTime +
                ", classDesc='" + classDesc + '\'' +
                ", coachId=" + coachId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", imgList=" + imgList +
                '}';
    }
}
