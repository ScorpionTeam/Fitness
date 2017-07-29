package com.fitness.api.domain;

/**
 * 印象
 * Created on 2017/7/29.
 */
public class Impression {

    /**
     * 主键
     */
    private Long id;

    /**
     * 印象名称
     */
    private String name;

    /**
     * 教练id
     */
    private Long coachId;

    /**
     * 会员id
     */
    private Long memberId;

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

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Impression{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coachId=" + coachId +
                ", memberId=" + memberId +
                '}';
    }
}
