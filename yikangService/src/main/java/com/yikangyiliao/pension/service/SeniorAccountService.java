package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.pension.common.constants.YKConstants;
import com.yikangyiliao.pension.dao.OperateServiceLogDao;
import com.yikangyiliao.pension.dao.SeniorAccountDao;
import com.yikangyiliao.pension.entity.OperateServiceLog;
import com.yikangyiliao.pension.entity.SeniorAccount;

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

	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	@Autowired
	private OperateServiceLogDao operateServiceLogDao;

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
				String birthYear = paramData.get("birthYear").toString();
				String cardNumber = paramData.get("cardNumber").toString();
				String cardType = paramData.get("cardType").toString();
				String socialSecurity = paramData.get("socialSecurity")
						.toString();
				String race = paramData.get("race").toString();
				String faith = paramData.get("faith").toString();
				String livingConditions = paramData.get("livingConditions")
						.toString();
				String paymentType = paramData.get("paymentType").toString();
				String incomeSources = paramData.get("incomeSources")
						.toString();
				String phoneNo = paramData.get("phoneNo").toString();
				String roomOrientation = paramData.get("roomOrientation")
						.toString();
				String outWindow = paramData.get("outWindow").toString();
				if (null != name && null != sex && null != birthday
						&& null != birthYear && null != cardNumber
						&& null != cardType && null != socialSecurity
						&& null != race && null != faith
						&& null != livingConditions && null != paymentType
						&& null != incomeSources && null != phoneNo
						&& null != roomOrientation && null != outWindow) {
					seniroAccount.setName(name);
					seniroAccount.setSex(Byte.valueOf(sex));
					seniroAccount.setBirthday(Long.parseLong(birthday));
					seniroAccount.setBirthYear(Integer.parseInt(birthYear));
					seniroAccount.setCardNumber(cardNumber);
					seniroAccount.setCardType(Byte.valueOf(cardType));
					seniroAccount.setSocialSecurity(socialSecurity);
					seniroAccount.setRace(race == "0" ? false : true);
					seniroAccount.setFaith(Byte.valueOf(faith));
					seniroAccount.setLivingConditions(Byte
							.valueOf(livingConditions));
					seniroAccount.setPaymentType(Byte.valueOf(paymentType));
					seniroAccount.setIncomeSources(Byte.valueOf(incomeSources));
					seniroAccount.setPhoneNo(phoneNo);
					seniroAccount.setRoomOrientation(Byte
							.valueOf(roomOrientation));
					seniroAccount.setOutWindow(outWindow == "0" ? false : true);
					seniroAccount.setCreateTime(currentDateTime.getTime());
					seniroAccount.setUpdateTime(currentDateTime.getTime());
					
					
					seniorAccountDao.insertSelective(seniroAccount);
					
					
					OperateServiceLog operateServiceLog=new OperateServiceLog();
					operateServiceLog.setCreateTime(currentDateTime.getTime());
					operateServiceLog.setUpdateTime(currentDateTime.getTime());
					operateServiceLog.setOperateType(YKConstants.OperateType.insert.getValue().byteValue());
					
					
					operateServiceLogDao.insertSelective(operateServiceLog);
					
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

}
