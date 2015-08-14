package com.yikangyiliao.pension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserDao;
import com.yikangyiliao.pension.entity.User;


@Component
public class UserManager {
	
	@Autowired
	private UserDao userDao;

	
	/**
	 * @author liushuaic
	 * @date 查询某一个用户
	 * **/
	public User selectByPrimaryKey(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}

}
