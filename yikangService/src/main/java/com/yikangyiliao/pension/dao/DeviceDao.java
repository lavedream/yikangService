package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Device;

public interface DeviceDao {
    int deleteByPrimaryKey(Long device_id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long device_id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}