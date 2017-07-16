package com.fitness.api.domain;

import java.util.Date;

/**
 * 教练 工作经历
 * Created on 2017/7/2.
 */
public class CoachJob {

    //主键
    private Long id;

    //工作开始时间
    private Date jobStart;

    //工作结束时间
    private Date jobEnd;

    //工作描述
    private String jobDesc;

    //创建时间
    private Date createDate;

    //教练id
    private Long coachId;

    //修改时间
    private Date updateDate;

    //工作经历状态  1 启用 0 停用
    private String status;

    //工作经历头部
    private String jobTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getJobStart() {
        return jobStart;
    }

    public void setJobStart(Date jobStart) {
        this.jobStart = jobStart;
    }

    public Date getJobEnd() {
        return jobEnd;
    }

    public void setJobEnd(Date jobEnd) {
        this.jobEnd = jobEnd;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "CoachJob{" +
                "id=" + id +
                ", jobStart=" + jobStart +
                ", jobEnd=" + jobEnd +
                ", jobDesc='" + jobDesc + '\'' +
                ", createDate=" + createDate +
                ", coachId=" + coachId +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
