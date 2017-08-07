package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 活动
 * Created on 2017/7/1.
 */
public class Activity {

    //主键
    private Long id;

    //活动名称
    private String name;

    //活动简介
    private String content;

    //报名截止时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date closingDate;

    //访问量
    private Integer visitTotal;

    //场馆id
    private Long stadiumId;

    //活动创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //活动开始时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    //活动结束时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    //活动状态 1正常 0 失效
    private String status;

    //活动排序
    private Integer sort;

    //活动修改时间
    private Date updateDate;

    //是否置顶  1是 0否
    private String showHome;

    //活动描述富文本
    private String contentHtml;

    //场馆名称
    @Transient
    private String stadiumName;

    //报名人数
    private Integer applyTotal;

    //报名人员列表
    @Transient
    private List<Member> memberList;

    public Integer getApplyTotal() {
        return applyTotal;
    }

    public void setApplyTotal(Integer applyTotal) {
        this.applyTotal = applyTotal;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getVisitTotal() {
        return visitTotal;
    }

    public void setVisitTotal(Integer visitTotal) {
        this.visitTotal = visitTotal;
    }

    public Long getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }

    public List<Member> getMemberList() {
        return memberList == null ? new ArrayList<>() : memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", closingDate=" + closingDate +
                ", visitTotal=" + visitTotal +
                ", stadiumId=" + stadiumId +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", sort=" + sort +
                ", updateDate=" + updateDate +
                ", showHome='" + showHome + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                ", stadiumName='" + stadiumName + '\'' +
                ", applyTotal=" + applyTotal +
                ", memberList=" + memberList +
                '}';
    }
}
