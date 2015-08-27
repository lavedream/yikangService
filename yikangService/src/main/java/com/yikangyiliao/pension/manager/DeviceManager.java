package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.DeviceDao;
import com.yikangyiliao.pension.dao.UserDeviceTabDao;
import com.yikangyiliao.pension.entity.Device;
import com.yikangyiliao.pension.entity.UserDeviceTab;


@Component
public class DeviceManager {
	
	
	@Autowired
	private DeviceDao deviceDao;
	
	
	@Autowired
	private UserDeviceTabDao userDeviceTabDao;
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 16:33
	 * @desc 添加设备
	 * **/
	public int insertDeviceSelective(Device device){
		return deviceDao.insertSelective(device);
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/26 19:38
	 * @desc 添加用户设备关系
	 * **/
	public int insertUserDeviceSelective(UserDeviceTab userDeviceTab){
		return userDeviceTabDao.insertSelective(userDeviceTab);
	}
	
	
}
