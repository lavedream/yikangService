package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.TimeQuantumDao;
import com.yikangyiliao.pension.entity.TimeQuantum;

@Component
public class TimeQuantumManager {

	@Autowired
	private TimeQuantumDao timeQuantumDao;
	
	
	
	/**
     * 
     * @author liushuaic
     * @date 2015/09/18 18:12
     * @desc 获取所有的时间段
     * 
     * **/
	public List<TimeQuantum> getAllTimeQuantum(){
		return timeQuantumDao.getAllTimeQuantum();
	}
	
}
