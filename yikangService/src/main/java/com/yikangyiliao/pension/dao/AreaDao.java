package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Area;

public interface AreaDao {
    int deleteByPrimaryKey(Long areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}