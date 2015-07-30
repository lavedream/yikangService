package com.yikangyiliao.pension.entity;

public class Device {
    private Long device_id;

    private Byte device_type;

    private String device_code;

    private String code_type;

    private Long create_time;

    private Long update_time;

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Byte getDevice_type() {
        return device_type;
    }

    public void setDevice_type(Byte device_type) {
        this.device_type = device_type;
    }

    public String getDevice_code() {
        return device_code;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code == null ? null : device_code.trim();
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type == null ? null : code_type.trim();
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
}