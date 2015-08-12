package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.dao.UserDao;
import com.yikangyiliao.pension.entity.User;



/**
 * @author liushuaic
 * @date 2015/07/25 13:28
 * 用于用户登陆
 * **/
@Service(value="login")
public class LoginService {
	
	
	@SuppressWarnings("unused")
	private static Logger logger=Logger.getLogger(LoginService.class);
	
	@Autowired
	private  UserDao userDao;

	/**
	 * @author liushuaic
	 * @date 2015/07/30 20:03 
	 * @desc 登陆
	 * 密码加密方式，
	 * solt  加密 
	 * password=加密（加密（password)+加密（solt）)
	 * */
	@SuppressWarnings("unused")
	public Map<String,Object> login(Map<String,Object> paramData){
		
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		
		

		if(paramData.containsKey("userName") && paramData.containsKey("password")){
			
			String userName=paramData.get("userName").toString();
			String passWord=paramData.get("password").toString();
			if(null != userName && null != passWord){
				
				
				User user=userDao.getUserByUserName(userName);
				if(null != user){
					
					String passwordStr=user.getLoginPassword();
					if(passWord.equals(passwordStr)){
						
						/**
						 * 
						 * 随机数+ip+logintime
						 * 验证方式，与 redis 中的内容对比 
						 * 对登陆时间
						 * 找出用户信息
						 * **/
						
						String accessTiket=user.getAccessTiket();
						Long currentDateTime=Calendar.getInstance().getTime().getTime();
						
						
						
						rtnData.put("accessTiket","");
						
						
					}
				
				}
			}
		}
		/**
		 * 
		 * 随机数+ip+logintime
		 * 验证方式，与 redis 中的内容对比 
		 * 
		 * 
		 * 对登陆时间
		 * 找出用户信息
		 * **/
		
		return rtnData;
		
	}
	
}
