package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

/**
 * 团课
 * Created on 2017/7/2.
 */
public class GroupClass {

    //主键
    private Long id;

    //团课名称
    private String name;

    //课程总人数
    private Integer total;

    //上课地点
    private String address;

    //剩余人数
    private Integer surplusNum;

    //团课开课时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    //团课结束时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    //团课时长
    private Integer timeTotal;

    //团课状态
    private String status;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    //教练id
    private Long coachId;

    //场馆名称
    @Transient
    private String stadiumName;

    //场馆id
    @Transient
    private Long stadiumId;

    //教练姓名
    @Transient
    private String coachName;

    //主图
    private String mainImgUrl;

    //轮播图
    @Transient
    private List<Img> imgList;

    /**
     * 课程评分
     */
    @Transient
    private Grade grade;


    public String getMainImgUrl() {
        return mainImgUrl == null ? "" : mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSurplusNum() {
        return surplusNum;
    }

    public void setSurplusNum(Integer surplusNum) {
        this.surplusNum = surplusNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(Integer timeTotal) {
        this.timeTotal = timeTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Long getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public List<Img> getImgList() {
        return imgList;
    }

    public void setImgList(List<Img> imgList) {
        this.imgList = imgList;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "GroupClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", address='" + address + '\'' +
                ", surplusNum=" + surplusNum +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", timeTotal=" + timeTotal +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", coachId=" + coachId +
                ", stadiumName='" + stadiumName + '\'' +
                ", stadiumId=" + stadiumId +
                ", coachName='" + coachName + '\'' +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", imgList=" + imgList +
                ", grade=" + grade +
                '}';
    }
}
