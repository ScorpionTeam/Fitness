package com.fitness.api.domain;

import java.util.Date;

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
    private Date startDate;

    //团课结束时间
    private Date endDate;

    //团课时长
    private Integer timeTotal;

    //团课状态
    private String status;

    //创建时间
    private Date createDate;

    //修改时间
    private Date updateDate;

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
                '}';
    }
}
