package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.pension.common.constants.YKConstants;
import com.yikangyiliao.pension.dao.OperateServiceLogDao;
import com.yikangyiliao.pension.dao.SeniorAccountDao;
import com.yikangyiliao.pension.dao.SeniorLivingConditionDao;
import com.yikangyiliao.pension.entity.OperateServiceLog;
import com.yikangyiliao.pension.entity.SeniorAccount;
import com.yikangyiliao.pension.entity.SeniorLivingCondition;

/**
 * @author liushuaic
 * @date 2015/07/28 10:45
 * @desc 患者操作
 * 
 * **/
@Service(value = "seniorAccountService")
public class SeniorAccountService {

	private static final Logger logger = Logger
			.getLogger(SeniorAccountService.class);
	
	private ObjectMapper objectMapper=new ObjectMapper();

	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	@Autowired
	private OperateServiceLogDao operateServiceLogDao;
	
	@Autowired
	private SeniorLivingConditionDao seniorLivingConditionDao;

	/**
	 * @author liushuaic
	 * @date 2015/07/28 10:45
	 * @desc 添加某一个患者
	 * **/
	public Map<String, Object> saveSeniorAccount(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			SeniorAccount seniroAccount = new SeniorAccount();

			try {
				
				Date currentDateTime=Calendar.getInstance().getTime();
				
				String name = paramData.get("name").toString();
				String sex = paramData.get("sex").toString();
				String birthday = paramData.get("birthday").toString();
				String birthYear = birthday.substring(0,birthday.indexOf("-"));
				String cardNumber = paramData.get("cardNumber").toString();
				String cardType = paramData.get("cardType").toString();
				String socialSecurity = paramData.get("socialSecurity").toString();
				String race = paramData.get("race").toString();
				String faith = paramData.get("faith").toString();
				String paymentType = paramData.get("paymentType").toString();
				String incomeSources = paramData.get("incomeSources").toString();
				String phoneNo = paramData.get("phoneNo").toString();
				
				
				
				String city = paramData.get("city").toString();
				String district = paramData.get("district").toString();
				String floor = paramData.get("floor").toString();
				String liveWith = paramData.get("liveWith").toString();
				String outWindow = paramData.get("outWindow").toString();
				String residentialQuarter = paramData.get("residentialQuarter").toString();
				String roomOrientation = paramData.get("roomOrientation").toString();
				String unit = paramData.get("unit").toString();
				String longitude = paramData.get("longitude").toString();
				String latitude = paramData.get("latitude").toString();
				
				
				
				if (null != name && null != sex && null != birthday
						&& null != birthYear && null != cardNumber
						&& null != cardType && null != socialSecurity
						&& null != race && null != faith
						&& null != paymentType
						&& null != incomeSources && null != phoneNo
						&& null != roomOrientation && null != outWindow) {
					seniroAccount.setName(name);
					seniroAccount.setSex(Byte.valueOf(sex));
					seniroAccount.setBirthday(DateUtils.getＭillisecond(birthday));
					seniroAccount.setBirthYear(Integer.parseInt(birthYear));
					seniroAccount.setCardNumber(cardNumber);
					seniroAccount.setCardType(Byte.valueOf(cardType));
					seniroAccount.setSocialSecurity(socialSecurity);
					seniroAccount.setRace(race == "0" ? false : true);
					seniroAccount.setFaith(Byte.valueOf(faith));
					seniroAccount.setPaymentType(Byte.valueOf(paymentType));
					seniroAccount.setIncomeSources(Byte.valueOf(incomeSources));
					seniroAccount.setPhoneNo(phoneNo);
					seniroAccount.setCreateTime(currentDateTime.getTime());
					seniroAccount.setUpdateTime(currentDateTime.getTime());
					
					
					seniorAccountDao.insertSelective(seniroAccount);
					
					
					OperateServiceLog operateServiceLog=new OperateServiceLog();
					operateServiceLog.setCreateTime(currentDateTime.getTime());
					operateServiceLog.setUpdateTime(currentDateTime.getTime());
					operateServiceLog.setOperateType(YKConstants.OperateType.insert.getValue().byteValue());
					operateServiceLog.setTableName("senior_account");
					operateServiceLog.setCreateUserId(-1l);
					operateServiceLog.setOpreateContent(objectMapper.writeValueAsString(paramData));
					operateServiceLogDao.insertSelective(operateServiceLog);
					
					SeniorLivingCondition seniorLivingCondition=new SeniorLivingCondition();
					
					seniorLivingCondition.setCity(city);
					seniorLivingCondition.setDistrict(district);
					seniorLivingCondition.setFloor(Integer.parseInt(floor));
					seniorLivingCondition.setLiveWith(Byte.parseByte(liveWith));
					seniorLivingCondition.setOutWindow(outWindow=="0"?false:true);
					seniorLivingCondition.setResidentialQuarter(residentialQuarter);
					seniorLivingCondition.setRoomOrientation(Byte.parseByte(roomOrientation));
					seniorLivingCondition.setSeniorId(seniroAccount.getSeniorId());
					seniorLivingCondition.setUnit(Integer.parseInt(unit));
					seniorLivingCondition.setLongitude(Double.parseDouble(longitude));
					seniorLivingCondition.setLatitude(Double.parseDouble(latitude));
					
					seniorLivingConditionDao.insertSelective(seniorLivingCondition);
					
					rtnData.put("status", "000000");
					rtnData.put("message", "保存成功！");
				} else {
					rtnData.put("status", "999999");
					rtnData.put("message", "数据不正确！");
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
				rtnData.put("status", "999999");
				rtnData.put("message", "数据不正确！");
			}

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
			e.printStackTrace();

		}

		return rtnData;

	}

	/**
	 * @author liushuaic
	 * @date 2015/07/28 18:06
	 * @desc 删除某一个患者
	 * 
	 * */
	public Map<String, Object> deleteSeniorAccountById(
			Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			if (null != paramData && null != paramData.get("seniorId")) {
				String seniorId = paramData.get("seniorId").toString();
				if (StringUtils.isEmpty(seniorId)) {
					seniorAccountDao.deleteByPrimaryKey(Long
							.parseLong(seniorId));
				}
			}
			rtnData.put("status", "000000");
			rtnData.put("message", "操作成功！");

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
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
	public Map<String, Object> updateSeniorAccountById(
			Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			if (null != paramData) {
				SeniorAccount seniorAccount = (SeniorAccount) paramData
						.get("seniroAccount");
				seniorAccountDao.updateByPrimaryKey(seniorAccount);
			}
			rtnData.put("status", "000000");
			rtnData.put("message", "操作成功！");

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
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
	public Map<String, Object> getSeniorAccountById(
			Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			if (null != paramData && null != paramData.get("seniorId")) {
				String seniorId = paramData.get("seniorId").toString();
				if (StringUtils.isEmpty(seniorId)) {
					SeniorAccount seniorAccount = seniorAccountDao
							.selectByPrimaryKey(Long.parseLong(seniorId));
					rtnData.put("data", seniorAccount);
				}
			}
			rtnData.put("status", "000000");
			rtnData.put("message", "操作成功！");

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
			e.printStackTrace();

		}

		return rtnData;
	}
	
    
    /**
     * @author liushuaic
     * @date 2015/07/30 18:50
     * @desc 查询某一个用户下的所有的 老人信息
     * 
     * */
	public  Map<String,Object> getSeniorAccountByUserId(Map<String,Object> paramData){
		Map<String, Object> rtnData = new HashMap<String, Object>();
		

		try {
			if(null != paramData.get("userId").toString()){
				String userId=paramData.get("userId").toString();
				seniorAccountDao.getSeniorAccountByUserId(Long.parseLong(userId));
				rtnData.put("status","000000");
				rtnData.put("message","操作成功！");
			}else {
				rtnData.put("status","999999");
				rtnData.put("message","操作失败！");
			}
			
		}catch(Exception e){
			logger.error(e.getMessage());
			rtnData.put("status","999999");
			rtnData.put("message","操作失败！");
			e.printStackTrace();
		}
    	return rtnData;
    }
}
