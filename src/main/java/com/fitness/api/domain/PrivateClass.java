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

    //教练名称
    @Transient
    private String coachName;

    //场馆id
    @Transient
    private Long stadiumId;

    //场馆名称
    @Transient
    private String stadiumName;

    //创建时间
    private Date createDate;

    //修改时间
    private Date updateDate;

    //开始时间
    private Date startDate;

    //主图  图片地址
    private String mainImgUrl;

    @Transient
    //课程图片集合
    private List<Img> imgList;

    //课程时间段
    @Transient
    private List<PrivateClassTime> privateClassTimeList;

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

    public List<PrivateClassTime> getPrivateClassTimeList() {
        return privateClassTimeList;
    }

    public void setPrivateClassTimeList(List<PrivateClassTime> privateClassTimeList) {
        this.privateClassTimeList = privateClassTimeList;
    }

    public Long getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    @Override
    public String toString() {
        return "PrivateClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classTime=" + classTime +
                ", classDesc='" + classDesc + '\'' +
                ", coachId=" + coachId +
                ", coachName='" + coachName + '\'' +
                ", stadiumId=" + stadiumId +
                ", stadiumName='" + stadiumName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", startDate=" + startDate +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", imgList=" + imgList +
                ", privateClassTimeList=" + privateClassTimeList +
                '}';
    }
}
