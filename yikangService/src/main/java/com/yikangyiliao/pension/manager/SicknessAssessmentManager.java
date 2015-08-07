package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyTableDao;


@Component
public class SicknessAssessmentManager {

	@Autowired
	private SurveyTableDao surveyTableDao;
	
	
	public Map<String,Object> getSicknessAssessment(){
		return surveyTableDao.getQuestionCrosswiseByTableNameTwo("疾病评估");
	}
	
}
