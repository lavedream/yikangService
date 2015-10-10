package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.AppointmentOrder;
import com.yikangyiliao.pension.manager.AppointmentOrderManager;

@Service(value="appointmentOrderService")
public class AppointmentOrderService {

	
	@Autowired
	private AppointmentOrderManager appointmentOrderManager;
	
	
	
	public Map<String,Object> addPointmentOrder(Map<String,Object> param){
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	null != param.get("parentLinkAddress")
			&& null != param.get("phoneNumber")
			&& null != param.get("myPhoneNumber")
			&& null != param.get("nickName")
			&& null != param.get("appointmentDateTime")
			&& null != param.get("timeQuanturmId")
			&& null != param.get("startTime")
			&& null != param.get("endTime")
			&& null != param.get("provenceCode")
			&& null != param.get("cityCode")
			&& null != param.get("districtCode")
			&& null != param.get("longitude")
			&& null != param.get("latitude")
			&& null != param.get("detailAddress")
			&& null != param.get("mapPostionAddress")
			&& null != param.get("serviceCount")
			&& null != param.get("dataSource")
			&& null != param.get("dataGroup")
		){
			
			
				AppointmentOrder appointmentOrder =new AppointmentOrder();
				
				 String parentLinkAddress	=  param.get("parentLinkAddress").toString();
				 String phoneNumber			=  param.get("phoneNumber").toString();
				 String myPhoneNumber		=  param.get("myPhoneNumber").toString();
				 String nickName			=  param.get("nickName").toString();
				 String appointmentDateTime	=  param.get("appointmentDateTime").toString();
				 String timeQuanturmId		=  param.get("timeQuanturmId").toString();
				 String startTime			=  param.get("startTime").toString();
				 String endTime				=  param.get("endTime").toString();
				 String provenceCode		=  param.get("provenceCode").toString();
				 String cityCode			=  param.get("cityCode").toString();
				 String districtCode		=  param.get("districtCode").toString();
				 String longitude			=  param.get("longitude").toString();
				 String latitude			=  param.get("latitude").toString();
				 String detailAddress		=  param.get("detailAddress").toString();
				 String mapPostionAddress	=  param.get("mapPostionAddress").toString();
				 String serviceCount		=  param.get("serviceCount").toString();
				 String dataSource			=  param.get("dataSource").toString();
				 String dataGroup			=  param.get("dataGroup").toString();
				
				
				 appointmentOrder.setParentLinkAddress(parentLinkAddress);
				 appointmentOrder.setPhoneNumber(phoneNumber);
				 appointmentOrder.setMyPhoneNumber(myPhoneNumber);
				 appointmentOrder.setNickName(nickName);
				// appointmentOrder.setAppointmentDateTime(appointmentDateTime);
				 appointmentOrder.setTimeQuanturmId(Long.valueOf(timeQuanturmId));
				 appointmentOrder.setStartTime(Integer.valueOf(startTime));
				 appointmentOrder.setEndTime(Integer.valueOf(endTime));
				 appointmentOrder.setProvenceCode(Long.valueOf(provenceCode));
				 appointmentOrder.setCityCode(Long.valueOf(cityCode));
				 appointmentOrder.setDistrictCode(Long.valueOf(districtCode));
				 appointmentOrder.setLongitude(Double.valueOf(longitude));
				 appointmentOrder.setLatitude(Double.valueOf(latitude));
				 appointmentOrder.setDetailAddress(detailAddress);
				 appointmentOrder.setMapPostionAddress(mapPostionAddress);
				 appointmentOrder.setServiceCount(Integer.valueOf(serviceCount));
				 appointmentOrder.setDataSource(Byte.valueOf(dataSource));
				 appointmentOrder.setDataGroup(Byte.valueOf(dataGroup));
				 
				 appointmentOrderManager.insertSelective(appointmentOrder);
				 
			 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		
		return rtnMap;
		
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/09 15:46 
	 * 获取某一个，预约单的，评估师
	 * */
	public Map<String,Object> getServiceUserByOrderId(Map<String,Object> param){
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		if(null != param.get("orderId")){
			String orderId=param.get("orderId").toString();
			
			int i=0;
			while(i<6){
				try {
					 Map<String,Object> userInfo=appointmentOrderManager.getUserServiceInfoByOrderId(Long.valueOf(orderId));
					 
					 if(null != userInfo){
						 rtnMap.put("userInfo", userInfo);
						 break;
					 }
					 
					 Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return rtnMap;
	
	}
	
	
}
