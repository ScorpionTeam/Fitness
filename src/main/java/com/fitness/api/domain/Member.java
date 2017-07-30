package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import java.text.Format;
import java.util.Date;

/**
 * 会员
 * Created on 2017/7/1.
 */
public class Member {

    //主键
    private Long id;

    //姓名
    private String name;

    //联系电话
    private String phone;

    //电话
    private String tel;

    //联系地址
    private String address;

    //性别
    private String sex;

    private Integer age;

    //出生日期
    @JSONField(format = "yyyy-MM-dd")
    private Date bornDate;

    //会员卡号码
    @Transient
    private String memberCardNo;

    //会员卡id
    @Transient
    private Long memberCardId;

    //密码
    private String password;

    //场馆id
    private Long stadiumId;

    //昵称
    private String nick;

    //邮箱
    private String email;

    //会员头像
    private String imgUrl;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    //会员状态
    //1.正常
    //2.审核中
    //3.审核不通过
    //4.注销
    private String status;

    //用户注册时选择卡类型
    private String type;

    //备注
    private String remark;

    //身份证
    private String identityCard;


    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getMemberCardNo() {
        return memberCardNo == null ? "" : memberCardNo;
    }

    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
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

    public String getTel() {
        return tel == null ? "" : tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address == null ? "" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex == null ? "" : sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age == null ? 0 : age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate == null ? new Date() : bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Long getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(Long memberCardId) {
        this.memberCardId = memberCardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getStadiumId() {
        return stadiumId == null ? 0l : stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getNick() {
        return nick == null ? "" : nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email == null ? "" : email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImgUrl() {
        return imgUrl==null?"":imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", bornDate=" + bornDate +
                ", memberCardNo='" + memberCardNo + '\'' +
                ", memberCardId=" + memberCardId +
                ", password='" + password + '\'' +
                ", stadiumId=" + stadiumId +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }
}
