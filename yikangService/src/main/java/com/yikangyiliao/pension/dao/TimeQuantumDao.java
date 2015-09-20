package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.TimeQuantum;

public interface TimeQuantumDao {
    int deleteByPrimaryKey(Long timeQuantumId);

    int insert(TimeQuantum record);

    int insertSelective(TimeQuantum record);

    TimeQuantum selectByPrimaryKey(Long timeQuantumId);

    int updateByPrimaryKeySelective(TimeQuantum record);

    int updateByPrimaryKey(TimeQuantum record);
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/09/18 18:12
     * @desc 获取所有的时间段
     * 
     * 
     * **/
    List<TimeQuantum> getAllTimeQuantum();
}