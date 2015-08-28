package com.yikangyiliao.pension.entity;

public class UserServiceInfo {
    private Long userServiceInfoId;

    private Long userId;

    private Long jobCategory;

    private String userPostion;

    private String provenceCode;

    private String cityCode;

    private String districtCode;

    private String addressDetail;

    private String photoUrl;

    private Long createTime;

    private Long updateTime;

    private Byte isDelete;

    private String userServiceName;

    public Long getUserServiceInfoId() {
        return userServiceInfoId;
    }

    public void setUserServiceInfoId(Long userServiceInfoId) {
        this.userServiceInfoId = userServiceInfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Long jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getUserPostion() {
        return userPostion;
    }

    public void setUserPostion(String userPostion) {
        this.userPostion = userPostion == null ? null : userPostion.trim();
    }

    public String getProvenceCode() {
        return provenceCode;
    }

    public void setProvenceCode(String provenceCode) {
        this.provenceCode = provenceCode == null ? null : provenceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getUserServiceName() {
        return userServiceName;
    }

    public void setUserServiceName(String userServiceName) {
        this.userServiceName = userServiceName == null ? null : userServiceName.trim();
    }
}