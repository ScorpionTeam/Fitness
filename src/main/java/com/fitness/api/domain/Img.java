package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 图片
 * Created on 2017/7/3.
 */
public class Img {

    //图片id
    private Long id;

    //图片Url
    private String url;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //第三方对应id
    private Long thirdId;

    public Long getThirdId() {
        return thirdId;
    }

    public void setThirdId(Long thirdId) {
        this.thirdId = thirdId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url == null ? "" : url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                ", thirdId=" + thirdId +
                '}';
    }
}
