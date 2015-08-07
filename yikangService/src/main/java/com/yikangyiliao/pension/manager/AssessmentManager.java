package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AssessmentDao;
import com.yikangyiliao.pension.entity.Assessment;


@Component
public class AssessmentManager {
	
	
	@Autowired
	private AssessmentDao assessmentDao;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/06  19:55
	 * 
	 * */
	public Assessment selectByPrimaryKey(Long assessmentId){
		return assessmentDao.selectByPrimaryKey(assessmentId);
	}
	
	

}
