package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyScoreDetailDao;


@Component
public class SurveyScoreDetailManager {

	
	@Autowired
	private SurveyScoreDetailDao surveyScoreDetailDao;
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/14 16:02
	 * 删除某一个表评测表下所有答案详情
	 * 
	 * */
	public int deleteSurveyScoreDetailBySurveyScoreId(Long surveyScoreId){
	    return surveyScoreDetailDao.deleteSurveyScoreDetailBySurveyScoreId(surveyScoreId);
	}
}
