package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;


/**
 * @author liushuaic
 * @date 2015/08/26 10:59
 * @desc 用户测试
 * 
 * **/
public class UserTest {

	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-01 登陆用户
	 * */
	@Test
	public void TestRegisterUser(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName","liushuai");
			paramData.put("passWord","liushuai");
			
			SendRequest.sendPost("regist",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-03 注册
	 * */
	@Test
	public void TestRegisterUserSaveServiceInfo(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName",53333233);
			paramData.put("passWord",1);
			paramData.put("passWord",1);
			paramData.put("jobCategory",1);
			paramData.put("cityCode",1);
			paramData.put("districtCode",1);
			paramData.put("addressDetail",1);
			paramData.put("userName","test2015/11/18");
			paramData.put("mapPositionAddress","光华护士基金");
			paramData.put("hospital","北京积水潭");
			paramData.put("offices","外科");
			paramData.put("adept","骨置换");
			paramData.put("userPosition","1");
			paramData.put("photoUrl","....");
			paramData.put("invitationCode","151119133");
			
			SendRequest.sendPost("registerUserAndSaveServiceInfo?appId=234&accessTiket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-04 查询服务人员信息
	 * */
	@Test
	public void TestGetServiceInfo(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-17-04?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void TestUpdateServiceInfo(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userName", "hello World!");
			
			SendRequest.sendPost("00-17-05?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void TestForgotPassword(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName", "13716907523");
			
			SendRequest.sendPost("00-17-06?appId=234&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TestUserNotAtSystem(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName", "13716907523");
			
			SendRequest.sendPost("00-17-07?appId=234&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TestResetPassword(){
		
		try{
//			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName", "13716907523");
			paramData.put("password", "password");
			
			SendRequest.sendPost("00-17-08?appId=234&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-02-26 15:31
	 * 查询获取推荐列表
	 * 
	 * */
	@Test
	public void TestGetUserInfo(){
		
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userStatus", 0);
			SendRequest.sendPost("00-17-09?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
}
