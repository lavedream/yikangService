package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserServiceInfo;

public interface UserServiceInfoDao {
    int deleteByPrimaryKey(Long userServiceInfoId);

    int insert(UserServiceInfo record);

    int insertSelective(UserServiceInfo record);

    UserServiceInfo selectByPrimaryKey(Long userServiceInfoId);

    int updateByPrimaryKeySelective(UserServiceInfo record);

    int updateByPrimaryKey(UserServiceInfo record);
}