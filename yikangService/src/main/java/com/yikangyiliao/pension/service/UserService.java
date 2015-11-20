package com.yikangyiliao.pension.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.InvitationCodeGnerateUtil;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.utils.map.MapUtils;
import com.yikangyiliao.pension.common.utils.map.model.GeoCodeModel;
import com.yikangyiliao.pension.entity.Location;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserFrom;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.LocationManager;
import com.yikangyiliao.pension.manager.UserFromManager;
import com.yikangyiliao.pension.manager.UserManager;


@Service(value="userService")
public class UserService {
	
	@Autowired
	private UserManager userManager;
	
	
	@Autowired
	private LocationManager locationManager;
	
	
	@Autowired
	private UserFromManager userFromManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 注册用户及保存用户信息
	 * **/
	public Map<String,Object> saveRegisterUserAndSaveServiceInfo(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
				  paramData.containsKey("loginName")
				&&paramData.containsKey("passWord")
				&&paramData.containsKey("userName")
				&&paramData.containsKey("jobCategory")//职位
			){
			String loginName=paramData.get("loginName").toString();
			User u=userManager.getUserByLoginName(loginName);
			if(null == u){
				
				Long currentDateTime=Calendar.getInstance().getTimeInMillis();
				
				String passWord=paramData.get("passWord").toString();
				String userName=paramData.get("userName").toString();
				String jobCategory=paramData.get("jobCategory").toString();
				
				String userPosition="-2";
				if(paramData.containsKey("userPosition")){
					userPosition=paramData.get("userPosition").toString(); 
				}
				String mapPositionAddress="";
				if(paramData.containsKey("mapPositionAddress")){
					 mapPositionAddress=paramData.get("mapPositionAddress").toString();
				}
				String districtCode="-2";
				if(paramData.containsKey("districtCode")){
					districtCode=paramData.get("districtCode").toString();
				}
				String addressDetail="";
				if(paramData.containsKey("addressDetail")){
					 addressDetail=paramData.get("addressDetail").toString();
				}
				
				String photoUrl="";
				if(paramData.containsKey("photoUrl")){
					photoUrl=paramData.get("photoUrl").toString();
				}
				
			
				User user=new User();
				user.setUserName(userName);
				user.setLoginName(loginName);
				user.setLoginPassword(passWord);
				user.setCreateTime(currentDateTime);
				user.setSalt("000000");
				user.setLoginTime(currentDateTime);
				
				userManager.insertUserSelective(user);
				userManager.updateInvitationCodeByUserId(InvitationCodeGnerateUtil.generateInvitationCode(user), user.getUserId());
				
				UserServiceInfo userServiceInfo=new UserServiceInfo();
				userServiceInfo.setUserId(user.getUserId());
				userServiceInfo.setPhotoUrl(photoUrl);
				userServiceInfo.setProvenceCode(Long.valueOf("0"));
				userServiceInfo.setAddressDetail(addressDetail);
				
				userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
				userServiceInfo.setUserPostion(Long.valueOf(userPosition));
				
				userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
				
				
				
				
				userServiceInfo.setCreateTime(currentDateTime);
				userServiceInfo.setUpdateTime(currentDateTime);
				userServiceInfo.setIsDelete(Byte.valueOf("0"));
				userServiceInfo.setUserServiceName(userName);
				
				
				
				if(paramData.containsKey("hospital")){
					String hospital=paramData.get("hospital").toString();
					userServiceInfo.setHospital(hospital);
				}
				if(paramData.containsKey("offices")){
					userServiceInfo.setOffices(paramData.get("offices").toString());
				}
				if(paramData.containsKey("adept")){
					userServiceInfo.setAdept(paramData.get("adept").toString());
				}
				
				
				// 反推一下，用户用户地址
				
				Location city	=locationManager.getCityByDistrictCode(districtCode);
				Location provence=locationManager.getProvenceByCityCode(districtCode);
				if(null != city){
					userServiceInfo.setCityCode(Long.valueOf(city.getAdministrativeCode()));
				}else{
					userServiceInfo.setCityCode(0L);
				}
				if(null != provence){
					userServiceInfo.setProvenceCode(Long.valueOf(provence.getAdministrativeCode()));
				}else{
					userServiceInfo.setProvenceCode(0L);
				}
				userServiceInfo.setMapPositionAddress(mapPositionAddress);
				
				 //设置经纬度
				if(mapPositionAddress.length()>0){
					 try {
						 if(null != city){
							 GeoCodeModel geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress, city.getAdministrativeCode());
							 if(null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
								 //  TODO 有可能模糊地址对应的有多个这个问题要修改
								 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
								 String lngStr=lngLatStr.split(",")[0];
								 String latStr=lngLatStr.split(",")[1];
								 userServiceInfo.setLongitude(Double.valueOf(lngStr));
								 userServiceInfo.setLatitude(Double.valueOf(latStr));
							 }else{
								 userServiceInfo.setLongitude(0d);
								 userServiceInfo.setLatitude(0d);
							 }
						 }else{
							 userServiceInfo.setLongitude(0d);
							 userServiceInfo.setLatitude(0d);
						 }
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					 userServiceInfo.setLongitude(0d);
					 userServiceInfo.setLatitude(0d);
				 }
				
				
				
				
				userManager.insertUserServiceSelective(userServiceInfo);
				
				if(paramData.containsKey("invitationCode")){
					UserFrom userFrom=new UserFrom();
					userFrom.setUserId(user.getUserId());
					userFrom.setFromUrl("");
					userFrom.setInvitationCode(Integer.valueOf(paramData.get("invitationCode").toString()));
					userFrom.setCreateTime(currentDateTime);
					userFrom.setUpdateTime(currentDateTime);
					//设置为用户注册
					userFrom.setUserFrom("5");
					userFrom.setUserStatus(Byte.valueOf("0"));
					userFrom.setNumbers(0l);
					userFrom.setActiveTime(0l);
					userFromManager.insertSelective(userFrom);
				}
				
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.operationException.userDuplicateException.errorCode);
				rtnData.put("message", ExceptionConstants.operationException.userDuplicateException.errorMessage);
			}
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 注册用户
	 * **/
	public Map<String,Object> registerUser(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("loginName")
			&&paramData.containsKey("passWord")
			){
			
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String loginName=paramData.get("loginName").toString();
			String passWord=paramData.get("passWord").toString();
			
			User user=new User();
			user.setUserName("");
			user.setLoginName(loginName);
			user.setLoginPassword(passWord);
			user.setCreateTime(currentDateTime);
			user.setSalt("000000");
			user.setLoginTime(currentDateTime);
			
			userManager.insertUserSelective(user);
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
	 * @date 2015/08/25 17:44 
	 * 注册用户及保存用户信息
	 * **/
	public Map<String,Object> saveServiceUserInfo(Map<String,Object> paramData){
		
		//用户id 在paramData中存着
		
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("userPostion") //职位
			&&paramData.containsKey("jobCategory") //全职，兼职
			&&paramData.containsKey("provenceCode")
			&&paramData.containsKey("cityCode")
			&&paramData.containsKey("districtCode")
			&&paramData.containsKey("addressDetail")
			&&paramData.containsKey("photoUrl")
			&&paramData.containsKey("userName")
			){
			
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String userId=paramData.get("userId").toString();
			String userPostion=paramData.get("userPostion").toString();
			String jobCategory=paramData.get("jobCategory").toString();
//			String provenceCode=paramData.get("provenceCode").toString();
			String cityCode=paramData.get("cityCode").toString();
			String districtCode=paramData.get("districtCode").toString();
			String addressDetail=paramData.get("addressDetail").toString();
			String photoUrl=paramData.get("photoUrl").toString();
			String userName=paramData.get("userName").toString();
			

			
			UserServiceInfo userServiceInfo=new UserServiceInfo();
			userServiceInfo.setUserId(Long.parseLong(userId));
			userServiceInfo.setPhotoUrl(photoUrl);
			userServiceInfo.setProvenceCode(Long.valueOf("0"));
			userServiceInfo.setCityCode(Long.valueOf(cityCode));
			userServiceInfo.setAddressDetail(addressDetail);
			userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
			userServiceInfo.setUserPostion(Long.valueOf(userPostion));
			userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
			userServiceInfo.setCreateTime(currentDateTime);
			userServiceInfo.setUpdateTime(currentDateTime);
			userServiceInfo.setUserServiceName(userName);
			
			User user=new User();
			user.setUserId(Long.valueOf(userId));
			user.setUserName(userName);
			userManager.updateUser(user);
			
			String address="";
			Location district=locationManager.getLocationByAdministrativeCode(districtCode);
			Location city	=locationManager.getCityByDistrictCode(districtCode);
			Location provence=locationManager.getProvenceByCityCode(districtCode);
			
			
			address=provence.getName()+city.getName()+district.getName()+addressDetail;
			 //设置经纬度
			if(address.length()>0){
				 try {
					 GeoCodeModel geoCodeModel=MapUtils.getGeoCodeModelByAddress(address, city.getAdministrativeCode());
					 if(null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
						 //  TODO 有可能模糊地址对应的有多个这个问题要修改
						 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
						 String lngStr=lngLatStr.split(",")[0];
						 String latStr=lngLatStr.split(",")[1];
						 userServiceInfo.setLongitude(Double.valueOf(lngStr));
						 userServiceInfo.setLatitude(Double.valueOf(latStr));
					 }
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			userManager.insertUserServiceSelective(userServiceInfo);
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
	 * @date 2015/08/25 17:44 
	 * 修改用户信息
	 * **/
	public Map<String,Object> updateUser(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("loginName")
			&&paramData.containsKey("passWord")
			){
			
//			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String loginName=paramData.get("loginName").toString();
			String passWord=paramData.get("passWord").toString();
			
			User user=new User();
			//user.setUserName("未填写");
			user.setLoginName(loginName);
			user.setLoginPassword(passWord);
			
			userManager.insertUserSelective(user);
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
	 * @date 2015/08/25 17:44 
	 * 修改用户信息
	 * **/
	public Map<String,Object> getUserServiceInfoByUserId(Map<String,Object> paramData){
			
			Map<String,Object> rtnData=new HashMap<String,Object>();
			
			String userId=paramData.get("userId").toString();
			
			Map<String,Object> userServiceInfo=userManager.getUserServiceInfoByUserId(Long.valueOf(userId));
			rtnData.put("data", userServiceInfo);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			return rtnData;
	}
	
	
	
	
}
