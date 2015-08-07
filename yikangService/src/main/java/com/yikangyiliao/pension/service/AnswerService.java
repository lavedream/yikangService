package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.dao.AssessmentDao;
import com.yikangyiliao.pension.dao.SurveyScoreDetailDao;
import com.yikangyiliao.pension.entity.Assessment;
import com.yikangyiliao.pension.entity.SurveyScore;
import com.yikangyiliao.pension.entity.SurveyScoreDetail;
import com.yikangyiliao.pension.manager.AnswerManager;
import com.yikangyiliao.pension.manager.AssessmentManager;
import com.yikangyiliao.pension.manager.SurveyScoreManager;



@Service(value="answerService")
public class AnswerService {
	
	private Logger logger =Logger.getLogger(AnswerService.class);

	
	@Autowired
	private AnswerManager answerManager;
	
	@Autowired
	private AssessmentManager assessmentManager;
	
	@Autowired
	private SurveyScoreManager surveyScoreManager;
	
	@Autowired
	private SurveyScoreDetailDao surveyScoreDetailDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/06 查询生活护理评估表的，评估项
	 * **/
	public Map<String, Object> saveAnswer(Map<String,Object> paramData) {
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(null != paramData){
				if(
					paramData.containsKey("assessmentId")&&
					paramData.containsKey("surveyTableId")&&
					paramData.containsKey("questions")
				){
					
					String assessmentId=paramData.get("assessmentId").toString();
					String surveyTableId=paramData.get("surveyTableId").toString();
					String score=paramData.get("score").toString();
					
					
					//获取传过来的问题数组
					List<Map<String,Object>> questions=(List<Map<String,Object>>)paramData.get("questions");
					
					
					Assessment assessment=assessmentManager.selectByPrimaryKey(Long.valueOf(assessmentId));
					if(null == assessment){
						assessment=new Assessment();
						//TODO如果进入到本页面，一定是添加了一个档案袋
						assessment.setAppraisersId(-1l);
						assessment.setAppraisersName("项目初期系统");
						assessment.setAssessmentId(-1l);
						assessment.setSeniorId(0l);
					}
					
					
					SurveyScore sureyScore=surveyScoreManager.getSureyScoreByAssessmentIdAndSureyTableId(paramData);
					if(null == sureyScore){
						sureyScore=new SurveyScore();
						sureyScore.setConclusionUserId(assessment.getAppraisersId());
						sureyScore.setConclusion("初始化");
						sureyScore.setAssessorUserId(assessment.getAppraisersId());
						
						sureyScore.setDataSource(Byte.valueOf("1"));
						sureyScore.setIsDelete(Byte.valueOf("0"));
						sureyScore.setSenorId(assessment.getSeniorId());
						sureyScore.setSurveyTableId(Long.valueOf(surveyTableId));
						sureyScore.setTotal(Integer.valueOf(score));
						
						surveyScoreManager.insertSelective(sureyScore);
					}else{
						//TODO 自动修改总分
						surveyScoreManager.updateTotalBySurveyScoreId(sureyScore.getSureyScoreId());
					}
					//[{questionId:1,answers:[{answerId:1,answerVal:1},{answerId:2,answerVal:1}]},{{questionId:2,answers:[{answerId:3,answerVal:1},{answerId:4,answerVal:1}]}}]
					for(int i=0;i<questions.size();i++){
						Map<String,Object> question=questions.get(i);
						
						String questionId=question.get("questionId").toString();
						List<Map<String,Object>> answers=(List<Map<String,Object>>)question.get("answers");
						for(int j=0;j<answers.size();j++){
							
							Map<String,Object> answer=answers.get(j);
							
							String answerVal=answer.get("answerVal").toString();
							String answerId=answer.get("answerId").toString();
							
							SurveyScoreDetail surveyScoreDetail=new SurveyScoreDetail();
							surveyScoreDetail.setAnswerId(Long.valueOf(answerId));
							surveyScoreDetail.setScore(Integer.valueOf(answerVal));
							surveyScoreDetail.setSurveyId(sureyScore.getSureyScoreId());
							surveyScoreDetail.setQuestionId(Long.valueOf(questionId));
							
							surveyScoreDetailDao.insert(surveyScoreDetail);
						}
						
					}
					
				}
			}
			
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
		
	}
	
	
}
