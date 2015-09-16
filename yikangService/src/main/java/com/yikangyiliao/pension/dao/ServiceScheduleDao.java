package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ServiceSchedule;

public interface ServiceScheduleDao {
    int deleteByPrimaryKey(Long serviceScheduleId);

    int insert(ServiceSchedule record);

    int insertSelective(ServiceSchedule record);

    ServiceSchedule selectByPrimaryKey(Long serviceScheduleId);

    int updateByPrimaryKeySelective(ServiceSchedule record);

    int updateByPrimaryKey(ServiceSchedule record);
}