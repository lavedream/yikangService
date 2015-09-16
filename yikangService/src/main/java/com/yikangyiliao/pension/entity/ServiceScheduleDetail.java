package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ServiceScheduleDetail {
    private Long serviceScheduleDetailId;

    private Long serviceScheuleId;

    private Date tieQuantumId;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    public Long getServiceScheduleDetailId() {
        return serviceScheduleDetailId;
    }

    public void setServiceScheduleDetailId(Long serviceScheduleDetailId) {
        this.serviceScheduleDetailId = serviceScheduleDetailId;
    }

    public Long getServiceScheuleId() {
        return serviceScheuleId;
    }

    public void setServiceScheuleId(Long serviceScheuleId) {
        this.serviceScheuleId = serviceScheuleId;
    }

    public Date getTieQuantumId() {
        return tieQuantumId;
    }

    public void setTieQuantumId(Date tieQuantumId) {
        this.tieQuantumId = tieQuantumId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}