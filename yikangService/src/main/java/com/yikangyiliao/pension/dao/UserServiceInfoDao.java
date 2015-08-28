package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserServiceInfo;

public interface UserServiceInfoDao {
    int deleteByPrimaryKey(Long userServiceInfoId);

    int insert(UserServiceInfo record);

    int insertSelective(UserServiceInfo record);

    UserServiceInfo selectByPrimaryKey(Long userServiceInfoId);

    int updateByPrimaryKeySelective(UserServiceInfo record);

    int updateByPrimaryKey(UserServiceInfo record);
    
    /**
     * @author liushuaic
     * @date 2015/08/28 11:59
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
    UserServiceInfo getUserServiceInfoByUserId(Long userIds);
}