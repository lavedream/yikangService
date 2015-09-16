package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ServiceScheduleDetail;

public interface ServiceScheduleDetailDao {
    int deleteByPrimaryKey(Long serviceScheduleDetailId);

    int insert(ServiceScheduleDetail record);

    int insertSelective(ServiceScheduleDetail record);

    ServiceScheduleDetail selectByPrimaryKey(Long serviceScheduleDetailId);

    int updateByPrimaryKeySelective(ServiceScheduleDetail record);

    int updateByPrimaryKey(ServiceScheduleDetail record);
}