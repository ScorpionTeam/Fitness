package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 场馆
 * Created on 2017/7/3.
 */
public class Stadium {

    //场馆id
    private Long id;

    //场馆名称
    private String name;

    //场馆地址
    private String address;

    //场馆图片
    private Long stadiumImgId;

    //场馆介绍
    private String content;

    //城市编码
    private Integer city;

    //创建时间
    @JSONField(format="yyyy-MM-dd")
    private Date createDate;

    //修改时间
    @JSONField(format="yyyy-MM-dd")
    private Date updateDate;

    //场馆状态  1 启用 0 停用
    private String status;

    /**
     * 场馆图片地址
     */
    @Transient
    private String imgPath;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getStadiumImgId() {
        return stadiumImgId;
    }

    public void setStadiumImgId(Long stadiumImgId) {
        this.stadiumImgId = stadiumImgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stadiumImgId=" + stadiumImgId +
                ", content='" + content + '\'' +
                ", city=" + city +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
