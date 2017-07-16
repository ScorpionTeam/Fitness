package com.fitness.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tony on 2017/7/8.
 */
public class Remark implements Serializable {

    private static final long serialVersionUID = 4600205429287084115L;

    /* 评分ID */
    private Long id;
    /* 评分 */
    private int score;
    /* 印象 */
    private String impression;
    /* 教练ID */
    private Long coachId;
    /* 教练姓名 */
    private String coachName;
    /* 会员ID */
    private Long memberId;
    /* 会员姓名 */
    private String memberName;
    /* 创建时间 */
    private Date createDate;
    /* 更新时间 */
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

}
