package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.SeniorAccount;

public interface SeniorAccountDao {
    int deleteByPrimaryKey(Long seniorId);

    int insert(SeniorAccount record);

    int insertSelective(SeniorAccount record);

    SeniorAccount selectByPrimaryKey(Long seniorId);

    int updateByPrimaryKeySelective(SeniorAccount record);

    int updateByPrimaryKey(SeniorAccount record);
}