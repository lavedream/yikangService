package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Adept;

public interface AdeptDao {
    int deleteByPrimaryKey(Long adeptId);

    int insert(Adept record);

    int insertSelective(Adept record);

    Adept selectByPrimaryKey(Long adeptId);

    int updateByPrimaryKeySelective(Adept record);

    int updateByPrimaryKey(Adept record);
    
    
    

    /**
     * 
     * @author liushuaic
     * @date 2016-03-16 17:32
     * @desc 获取擅长列表
     * 
     * ***/
    List<Adept> getAdeptsByType(Long type);
    
    
    
    
}