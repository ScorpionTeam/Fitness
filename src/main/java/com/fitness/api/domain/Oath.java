package com.fitness.api.domain;

/**
 * 授权对象
 * Created on 2017/7/12.
 */
public class Oath {

    //授权码
    private String oath;

    //会员
    private Member member;

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Oath{" +
                "oath='" + oath + '\'' +
                ", member=" + member +
                '}';
    }
}
