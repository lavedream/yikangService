package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.AliasFactory;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.Device;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserDeviceTab;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.manager.DeviceManager;
import com.yikangyiliao.pension.manager.UserManager;



@Service(value="deviceService")
public class DeviceService {

	
	@Autowired
	private DeviceManager deviceManager;
	
	@Autowired
	private UserManager userManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 16:53 
	 *  添加设备
	 *  deviceType  设备类型
	 *  deviceCode  设备编码
	 *  codeType	编码类型
	 *  
	 * **/
	public Map<String,Object> saveDevice(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("deviceType")
			&&paramData.containsKey("deviceCode")
			&&paramData.containsKey("codeType")
			){
			
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String deviceType=paramData.get("deviceType").toString();
			String deviceCode=paramData.get("deviceCode").toString();
			String codeType=paramData.get("codeType").toString();
			
			String userId=paramData.get("userId").toString();
			
			Device device=new Device();
			device.setCodeType(codeType);
			device.setDeviceType(Byte.valueOf(deviceType));
			device.setDeviceCode(deviceCode);
			device.setCreateTime(currentDateTime);
			device.setUpdateTime(currentDateTime);
			
			
			deviceManager.insertDeviceSelective(device);
			
			UserDeviceTab userDeviceTab=new UserDeviceTab();
			userDeviceTab.setCreateTime(currentDateTime);
			userDeviceTab.setUpdateTime(currentDateTime);
			userDeviceTab.setUserId(Long.valueOf(userId));
			userDeviceTab.setDeviceId(device.getDeviceId());
			
			
			
			deviceManager.insertUserDeviceSelective(userDeviceTab);
			
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/16 10:49
	 * @desc 获取用户的检测别名
	 * **/
	public Map<String,Object> getAliasByUser(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String,Object>();
		
		String userId=paramData.get("userId").toString();
		
		//UserInfo userInfo=userManager.getUserInfoByUserId(Long.valueOf(userId));
		User user=userManager.selectByPrimaryKey(Long.valueOf(userId));
		if(null != user){
			//String alias=AliasFactory.generateAliasByUser(userInfo);
			String alias=AliasFactory.generateAliasByUser(user);
			Map<String,String> dataMap=new HashMap<String,String>();
			dataMap.put("alias", alias);
			rtnData.put("data", dataMap);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message",ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return rtnData;
		
	}
	
	
	
}
