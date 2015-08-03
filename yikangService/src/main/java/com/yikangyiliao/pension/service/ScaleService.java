package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.utils.GenreateNumberUtils;
import com.yikangyiliao.pension.dao.AssessmentDao;
import com.yikangyiliao.pension.dao.PerceptionCommunicationDao;
import com.yikangyiliao.pension.dao.SocialParticipationDao;
import com.yikangyiliao.pension.entity.Assessment;
import com.yikangyiliao.pension.entity.PerceptionCommunication;
import com.yikangyiliao.pension.entity.SocialParticipation;

@Service(value="scaleService")
public class ScaleService {
	
	private Logger logger =Logger.getLogger(ScaleService.class);
	
	@Autowired
	private PerceptionCommunicationDao perceptionCommunicationDao;
	
	@Autowired
	private  AssessmentDao assessmentdao;
	
	@Autowired
	private SocialParticipationDao socialParticipationDao;
	
	
	/**
	 * 生成项目编号
	 * **/
	@Autowired
	private GenreateNumberUtils genreateNumberUtils; 
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/30 14:49
	 * @desc 保存感知与沟通 
	 * 
	 * */
	public Map<String,Object> savePerceptionCommunications(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("consciousness")
				&&paramData.containsKey("vision")
				&&paramData.containsKey("hearing")
				&&paramData.containsKey("communication")
				&&paramData.containsKey("assessmentId")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				String consciousness=paramData.get("consciousness").toString();
				String vision=paramData.get("vision").toString();
				String hearing=paramData.get("hearing").toString();
				String communication=paramData.get("communication").toString();
				String assessmentId=paramData.get("assessmentId").toString();
				
				PerceptionCommunication  perceptionCommunication=new  PerceptionCommunication();
				perceptionCommunication.setCommunication(Byte.parseByte(communication));
				perceptionCommunication.setVision(Byte.parseByte(vision));
				perceptionCommunication.setHearing(Byte.parseByte(hearing));
				perceptionCommunication.setConsciousness(Byte.parseByte(consciousness));
				perceptionCommunication.setCreateTime(currentDateTime);
				perceptionCommunication.setUpdateTime(currentDateTime);
				perceptionCommunication.setAssessmentId(Long.parseLong(assessmentId));
				perceptionCommunication.setPerceptionCommunicationId("1a3_"+assessmentId);
				
				perceptionCommunicationDao.insert(perceptionCommunication);
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
	
		return rtnData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/31 18:35
	 * @desc 保存档案袋
	 * @param assessmentName
	 * **/
	public Map<String,Object> saveAssessment(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("assessmentName")&&
				paramData.containsKey("seniorId")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				String assessmentName=paramData.get("assessmentName").toString();
				String seniorId=paramData.get("seniorId").toString();
				
				Assessment assessment=new Assessment();
				assessment.setAssessmentName(assessmentName);
				String number=genreateNumberUtils.generateAssessmentNumber("LS","LS");
				assessment.setAssessmentNumber(number);
				assessment.setCreateTime(currentDateTime);
				assessment.setUpdateTime(currentDateTime);
				assessment.setSeniorId(Long.parseLong(seniorId));
				assessment.setOnlineAssess(true);
				
				assessmentdao.insertSelective(assessment);
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
	
	
	public Map<String,Object> saveSocialParticipation(Map<String,Object> paramData){
		
//		assessmentId:1		(检查袋id)
//		viability:1			(生成处理能力)
//		workingAbility:1		(工作能力）
//		temporalOrientation:1	(时空定向）
//		personalOrientation:1		(人物定向)
//		socialIntercourse:1		(社会交往能力)
//		totalScore:1			(总分)

		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("assessmentId")&&
				paramData.containsKey("viability")&&
				paramData.containsKey("workingAbility")&&
				paramData.containsKey("temporalOrientation")&&
				paramData.containsKey("personalOrientation")&&
				paramData.containsKey("socialIntercourse")&&
				paramData.containsKey("totalScore")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				
				
				String assessmentId= paramData.get("assessmentId").toString();
				String viability=paramData.get("viability").toString();
				String workingAbility=paramData.get("workingAbility").toString();
				String temporalOrientation=paramData.get("temporalOrientation").toString();
				String personalOrientation=paramData.get("personalOrientation").toString();
				String socialIntercourse=paramData.get("socialIntercourse").toString();
				String totalScore=paramData.get("totalScore").toString();
			
				SocialParticipation socialParticipation=new SocialParticipation();
				
				socialParticipation.setCreateTime(currentDateTime);
				socialParticipation.setUpdateTime(currentDateTime);
				
				socialParticipation.setAssessmentId(Long.parseLong(assessmentId));
				socialParticipation.setViability(Byte.valueOf(viability));
				socialParticipation.setWorkingAbility(Byte.valueOf(workingAbility));
				socialParticipation.setTemporalOrientation(Byte.valueOf(temporalOrientation));
				socialParticipation.setPersonalOrientation(Byte.valueOf(personalOrientation));
				socialParticipation.setSocialIntercourse(Byte.valueOf(socialIntercourse));
				socialParticipation.setTotalScore(Integer.parseInt(totalScore));
				socialParticipation.setSocialParticipationId("1a4_"+assessmentId);
				
				
				
				
				socialParticipationDao.insertSelective(socialParticipation);
				
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
}
