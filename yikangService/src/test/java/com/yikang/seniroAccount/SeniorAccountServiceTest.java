package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class SeniorAccountServiceTest {

	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-01 接口保存患者信息
	 * */
	@Test
	public void TestSaveSeniroAccount(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userId",1);
			
			SendRequest.sendPost("00-01-03",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-03 查询某一个用户下的所有人
	 * getSeniorAccountByUserId
	 * */
	@Test
	public void TestGetSeniorAccountByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userId",1);
			
			SendRequest.sendPost("00-01-03",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
