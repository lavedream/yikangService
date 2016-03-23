package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AdeptDao;
import com.yikangyiliao.pension.entity.Adept;

@Component
public class AdeptManager {

	@Autowired
	private AdeptDao adeptDao;
	
	
	
	public List<Adept> getAdeptsForDoctor(){
		return null;
	}
	
	
	
    /**
     * @author liushuaic
     * @date 2016-03-16 17:32
     * @desc 获取擅长列表
     * ***/
	public List<Adept> getAdeptsByType(Long type){
		return adeptDao.getAdeptsByType(type);
	}
	
	
	
	
}
