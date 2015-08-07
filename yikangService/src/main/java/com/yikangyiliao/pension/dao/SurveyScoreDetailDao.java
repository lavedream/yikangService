package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.SurveyScoreDetail;

public interface SurveyScoreDetailDao {
    int deleteByPrimaryKey(Long surveyScoreDetailId);

    int insert(SurveyScoreDetail record);

    int insertSelective(SurveyScoreDetail record);

    SurveyScoreDetail selectByPrimaryKey(Long surveyScoreDetailId);

    int updateByPrimaryKeySelective(SurveyScoreDetail record);

    int updateByPrimaryKey(SurveyScoreDetail record);
}