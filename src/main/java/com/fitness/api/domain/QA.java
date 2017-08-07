package com.fitness.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Transient;

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

    //状态  1正常  0删除
    private String status;

    //会员名称
    @Transient
    private String memberName;

    //回答状态  1 已回答 0 未回答
    @Transient
    private String answerStatus;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAnswerStatus() {
        return this.answer == null ? "0" : "1";
    }

    public void setAnswerStatus(String answerStatus) {
        this.answerStatus = answerStatus;
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
                ", status='" + status + '\'' +
                ", memberName='" + memberName + '\'' +
                ", answerStatus='" + answerStatus + '\'' +
                '}';
    }
}
