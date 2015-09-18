package com.yikangyiliao.pension.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yikangyiliao.pension.dao.ServiceScheduleDao;
import com.yikangyiliao.pension.dao.ServiceScheduleDetailDao;
import com.yikangyiliao.pension.dao.UserServiceInfoDao;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.UserManager;

/**
 * @author liushuaic
 * @date 2015/09/17 10:54 
 * 服务人员定时任务表
 * 生动生成，下一天的工作内容
 * 后期自己定义工作时间，
 * 1.判断是否已经生成。
 * 2.如果生成，就不在生成。
 * 3.如果没有，就生成记录。
 * **/

public class ServicerSchedule {
	
	@Autowired
	private ServiceScheduleDao serviceScheduleDao;
	
	
	@Autowired
	private ServiceScheduleDetailDao serviceScheduleDetailDao;

	
	@Autowired
	private UserManager userManager;
	
	
	/**
	 * @author liushuaic
	 * @date  2015/09/17 11:04
	 * 为评估服务人员生成 每天的，可服务时间段
	 * 
	 * */
	public void GenerateServiceSchedulDetailForServicerPingGu(){
		List<UserServiceInfo> userServiceInfoList= userManager.getPingGuServiceAll();
		if(null != userServiceInfoList){
			for(UserServiceInfo userServiceInfo:userServiceInfoList){
				
				Long userId=userServiceInfo.getUserId();
				
			}
		}
	}
	
}
