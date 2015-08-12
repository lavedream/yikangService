package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.SurveyTable;

public interface SurveyTableDao {
    int deleteByPrimaryKey(Long surveyTableId);

    int insert(SurveyTable record);

    int insertSelective(SurveyTable record);

    SurveyTable selectByPrimaryKey(Long surveyTableId);

    int updateByPrimaryKeySelective(SurveyTable record);

    int updateByPrimaryKey(SurveyTable record);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/06
     * 
     * **/
    List<Map<String,Object>> getQuestionCrosswiseByTableName(String tableName);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/06
     * 
     * **/
    Map<String,Object> getQuestionCrosswiseByTableNameTwo(String tableName);
    
    
    
    /**
     * @author liushuaic
     * @date	2015/08/12 11:47
     * @desc 根据某一个表，查询出所有的问题及答案
     * */
    Map<String,Object> getQuestionsAndAnswersByTableName(String tableName);
}