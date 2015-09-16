package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.TimeQuantum;

public interface TimeQuantumDao {
    int deleteByPrimaryKey(Long timeQuantumId);

    int insert(TimeQuantum record);

    int insertSelective(TimeQuantum record);

    TimeQuantum selectByPrimaryKey(Long timeQuantumId);

    int updateByPrimaryKeySelective(TimeQuantum record);

    int updateByPrimaryKey(TimeQuantum record);
}