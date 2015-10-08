package com.yikangyiliao.pension.entity;

import java.util.Date;

public class OrderServiceDetail {
    private Long orderServiceDetailId;

    private Long serviceUserId;

    private Byte serviceType;

    private Date serviceDate;

    private String appointmentDate;

    private String serviceRecord;

    private Long createTime;

    private Long updateTime;

    private String serviceDetailStatus;

    private Long orderId;

    public Long getOrderServiceDetailId() {
        return orderServiceDetailId;
    }

    public void setOrderServiceDetailId(Long orderServiceDetailId) {
        this.orderServiceDetailId = orderServiceDetailId;
    }

    public Long getServiceUserId() {
        return serviceUserId;
    }

    public void setServiceUserId(Long serviceUserId) {
        this.serviceUserId = serviceUserId;
    }

    public Byte getServiceType() {
        return serviceType;
    }

    public void setServiceType(Byte serviceType) {
        this.serviceType = serviceType;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate == null ? null : appointmentDate.trim();
    }

    public String getServiceRecord() {
        return serviceRecord;
    }

    public void setServiceRecord(String serviceRecord) {
        this.serviceRecord = serviceRecord == null ? null : serviceRecord.trim();
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

    public String getServiceDetailStatus() {
        return serviceDetailStatus;
    }

    public void setServiceDetailStatus(String serviceDetailStatus) {
        this.serviceDetailStatus = serviceDetailStatus == null ? null : serviceDetailStatus.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}