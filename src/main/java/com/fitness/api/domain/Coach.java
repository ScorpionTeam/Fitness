package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * 教练
 * Created on 2017/7/1.
 */
public class Coach {

    //主键
    private Long id;

    //姓名
    private String name;

    //联系电话
    private String phone;

    //介绍
    private String description;

    //场馆id
    private Long stadiumId;

    //场馆名称
    @Transient
    private String stadiumName;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    //头像图片id
    private Long coachImgId;

    //发证机构
    private String organization;

    //认证有效期
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date validDate;

    //机构发证日期
    private Date orgDate;

    //状态  1在职   0 离职
    private String status;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCoachImgId() {
        return coachImgId;
    }

    public void setCoachImgId(Long coachImgId) {
        this.coachImgId = coachImgId;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrgDate() {
        return orgDate;
    }

    public void setOrgDate(Date orgDate) {
        this.orgDate = orgDate;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", stadiumId=" + stadiumId +
                ", stadiumName='" + stadiumName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", coachImgId=" + coachImgId +
                ", organization='" + organization + '\'' +
                ", validDate=" + validDate +
                ", orgDate=" + orgDate +
                ", status='" + status + '\'' +
                '}';
    }
}
