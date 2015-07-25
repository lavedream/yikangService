package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;



/**
 * @author liushuaic
 * @date 2015/07/25 13:28
 * 用于用户登陆
 * **/
@Service(value="login")
public class LoginService {

	
	public Map<String,Object> login(Map<String,Object> paramData){
		
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		
		rtnData.put("data",null);
		return rtnData;
		
	}
	
}
