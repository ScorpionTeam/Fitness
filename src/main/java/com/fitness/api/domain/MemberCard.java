package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 会员卡
 * Created on 2017/7/2.
 */
public class MemberCard {

    //主键
    private Long id;

    //会员卡号
    private String cardNo;

    //会员卡类型
    //1.月卡
    //2.季卡
    //3.半年卡
    //4.年卡
    //5.次卡
    private String type;

    @Transient
    private String typeName;

    //场馆id
    private Long stadiumId;

    //有效开始时间
    @JSONField(format = "yyyy-MM-dd")
    private Date startDate;

    //有效结束时间
    @JSONField(format = "yyyy-MM-dd")
    private Date endDate;

    //创建时间
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;

    //修改时间
    @JSONField(format = "yyyy-MM-dd")
    private Date updateDate;

    //会员卡状态  1 可用 2已绑  0 失效
    private String status;

    //课程数量
    private Integer classTotal;

    //会员卡金额
    private Long money;

    //有效期拼接字符串
    @Transient
    private String validDate;

    public String getValidDate() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return validDate = sf.format(this.startDate) + "-" + sf.format(this.endDate);
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
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

    public Integer getClassTotal() {
        return classTotal;
    }

    public void setClassTotal(Integer classTotal) {
        this.classTotal = classTotal;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    //1.月卡
    //2.季卡
    //3.半年卡
    //4.年卡
    //5.次卡
    public String getTypeName() {
        return this.type.equals("1") ? "月卡" : this.type.equals("2") ? "季卡" : this.type.equals(
                "3") ? "半年卡" : this.type.equals("4") ? "年卡" : "次卡";
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "MemberCard{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", stadiumId=" + stadiumId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", classTotal=" + classTotal +
                ", money=" + money +
                ", validDate='" + validDate + '\'' +
                '}';
    }
}
