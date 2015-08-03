package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Assessment;

public interface AssessmentDao {
    int deleteByPrimaryKey(Long assessmentId);

    int insert(Assessment record);

    int insertSelective(Assessment record);

    Assessment selectByPrimaryKey(Long assessmentId);

    int updateByPrimaryKeySelective(Assessment record);

    int updateByPrimaryKey(Assessment record);
}