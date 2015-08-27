package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.Device;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserDeviceTab;
import com.yikangyiliao.pension.manager.DeviceManager;



@Service(value="deviceService")
public class DeviceService {

	
	@Autowired
	private DeviceManager deviceManager;
	
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
	
}
