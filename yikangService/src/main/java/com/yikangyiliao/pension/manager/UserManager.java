package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserDao;
import com.yikangyiliao.pension.dao.UserInfoDao;
import com.yikangyiliao.pension.dao.UserServiceInfoDao;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserServiceInfo;


@Component
public class UserManager {
	
	@Autowired
	private UserDao userDao;

	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:20
	 * @desc 添加用户信息
	 * **/
	public int insertUserSelective(User user){
		return userDao.insertSelective(user);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:24
	 * @desc 添加服务人员信息
	 * */
	public int insertUserServiceSelective(UserServiceInfo userServiceInfo){
		return userServiceInfoDao.insertSelective(userServiceInfo);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 查询某一个用户
	 * **/
	public User selectByPrimaryKey(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 11:09 修改用户信息
	 * */
	public int updateUser(User user){
		return userDao.updateByPrimaryKeySelective(user);
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/08/27 19:13 
	 * 查询某一个用户
	 * */
	public User getUserByLoginName(String loginName){
		return userDao.getUserByLoginName(loginName);
	}
	
	 /**
     * @author liushuaic
     * @date 2015/08/28 11:59
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
	public Map<String,Object> getUserServiceInfoByUserId(Long userId){
		return userServiceInfoDao.getUserServiceInfoByUserId(userId);
	}
	
	
}
