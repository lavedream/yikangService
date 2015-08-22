package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyTableDao;
import com.yikangyiliao.pension.entity.SurveyTable;


@Component
public class SurveyTableManager {

	@Autowired
	private SurveyTableDao surveyTableDao;
	
	/**
	 * @author liushuaic
	 * @date 2015/08/18 16:56s
	 * 获取某一个评估表的状态
	 * 
	 * */
	public List<Map<String,Object>> getTableList(Long assessmentId){
		return surveyTableDao.getTableListByAssessmentId(assessmentId);
	}
	
    /**
     * @author liushuaic
     * @date 2015/08/19 15:20
     * @param assessmentId 档案袋id
     * @param surveyTableId 表id
｀     * */
	public Map<String,Object> getQuestionsAndAnswersIsCheck(Map<String,Object> paramData){
		return surveyTableDao.getQuestionsAndAnswersIsCheck(paramData);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/08/20 14:20
     * @param assessmentId 档案袋id
     * @param surveyTableId 表id
     * @param questionCrosswiseId 问题分类id
｀     * */
	public Map<String,Object> getQuestionAndAnswersIsCheckTwo(Map<String,Object> paramData){
    	return surveyTableDao.getQuestionAndAnswersIsCheckTwo(paramData);
    }
}
