package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserAdeptMap;

public interface UserAdeptMapDao {
    int deleteByPrimaryKey(Long userAdeptMapId);

    int insert(UserAdeptMap record);

    int insertSelective(UserAdeptMap record);

    UserAdeptMap selectByPrimaryKey(Long userAdeptMapId);

    int updateByPrimaryKeySelective(UserAdeptMap record);

    int updateByPrimaryKey(UserAdeptMap record);
}