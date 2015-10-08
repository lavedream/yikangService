package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.AppointmentOrder;

public interface AppointmentOrderDao {
    int deleteByPrimaryKey(Long appointmentOrderId);

    int insert(AppointmentOrder record);

    int insertSelective(AppointmentOrder record);

    AppointmentOrder selectByPrimaryKey(Long appointmentOrderId);

    int updateByPrimaryKeySelective(AppointmentOrder record);

    int updateByPrimaryKey(AppointmentOrder record);
}