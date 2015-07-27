package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.pension.dao.SeniorAccountDao;
import com.yikangyiliao.pension.entity.SeniorAccount;



@Service(value="seniorAccountService")
public class SeniorAccountService {
	
	private static final Logger logger =Logger.getLogger(SeniorAccountService.class);
	
	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	
	public Map<String,Object> saveSeniorAccount(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		
		try{
			
			SeniorAccount seniroAccount=new SeniorAccount();
			
			seniroAccount.setBirthday(12341l);
			seniroAccount.setBirthYear(1231);
			seniroAccount.setName("你好！");
			seniroAccount.setLivingConditions(new Integer(1).byteValue());
			
			seniorAccountDao.insertSelective(seniroAccount);
			rtnData.put("status","000000");
			rtnData.put("message","保存成功！");
			
		}catch(Exception e){
			
			logger.error(e);
			
			rtnData.put("status","999999");
			rtnData.put("message","保存失败！");
			e.printStackTrace();
			
		}
		
		return rtnData;
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/07/27 18:06 
	 * @desc 查询某一个患者
	 * 
	 * */
	public Map<String,Object> getSeniorAccountById(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		
		try{
			
			if(null != paramData && null != paramData.get("seniorId")){
				String seniorId=paramData.get("seniorId").toString();
				if(StringUtils.isEmpty(seniorId)){
					SeniorAccount seniorAccount=seniorAccountDao.selectByPrimaryKey(Long.parseLong(seniorId));
					rtnData.put("data", seniorAccount);
				}
			}
			rtnData.put("status","000000");
			rtnData.put("message","保存成功！");
			
		}catch(Exception e){
			
			logger.error(e);
			
			rtnData.put("status","999999");
			rtnData.put("message","保存失败！");
			e.printStackTrace();
			
		}
		
		return rtnData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/07/27 18:06 
	 * @desc 查询某一个患者
	 * 
	 * */
	public Map<String,Object> updateSeniorAccountById(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		
		try{
			
			if(null != paramData){
				SeniorAccount seniorAccount =(SeniorAccount) paramData.get("seniroAccount");
				seniorAccountDao.updateByPrimaryKey(seniorAccount);
			}
			rtnData.put("status","000000");
			rtnData.put("message","操作成功！");
			
		}catch(Exception e){
			
			logger.error(e);
			
			rtnData.put("status","999999");
			rtnData.put("message","保存失败！");
			e.printStackTrace();
			
		}
		
		return rtnData;
	}

}
