package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.dao.UserDao;



/**
 * @author liushuaic
 * @date 2015/07/25 13:28
 * 用于用户登陆
 * **/
@Service(value="login")
public class LoginService {
	
	
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
	public Map<String,Object> login(Map<String,Object> paramData){
		
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		

		if(paramData.containsKey("userName") && paramData.containsKey("password")){
			
			String userName=paramData.get("userName").toString();
			String passWord=paramData.get("password").toString();
			if(null != userName && null != passWord){
				
			}
			
		}
		
		rtnData.put("accessTiket","");
		return rtnData;
		
	}
	
}
