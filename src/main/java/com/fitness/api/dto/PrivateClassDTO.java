package com.fitness.api.dto;

/**
 * 私教课DTO
 * Created by THINK on 2017/7/23.
 */
public class PrivateClassDTO {

    /* 课程名 */
    private String name;
    /* 私教课id */
    private Long privateClassId;
    /* 时间点 */
    private String times;
    /* 教学时长 */
    private int classTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrivateClassId() {
        return privateClassId;
    }

    public void setPrivateClassId(Long privateClassId) {
        this.privateClassId = privateClassId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = classTime;
    }

    @Override
    public String toString() {
        return "PrivateClassDTO{" +
                "name='" + name + '\'' +
                ", privateClassId=" + privateClassId +
                ", times='" + times + '\'' +
                ", classTime=" + classTime +
                '}';
    }
}
