package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/8/2.
 */
public class QA {

    //主键
    private Long id;

    //问题
    private String question;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createDate;

    //会员id
    private Long memberId;

    //回答
    private String answer;

    //管理人员id
    private Long userId;

    //回答时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date answerDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    @Override
    public String toString() {
        return "QA{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", createDate=" + createDate +
                ", memberId=" + memberId +
                ", answer='" + answer + '\'' +
                ", userId=" + userId +
                ", answerDate=" + answerDate +
                '}';
    }
}
