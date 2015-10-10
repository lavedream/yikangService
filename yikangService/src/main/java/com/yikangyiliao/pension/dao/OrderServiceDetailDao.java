package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.OrderServiceDetail;

public interface OrderServiceDetailDao {
    int deleteByPrimaryKey(Long orderServiceDetailId);

    int insert(OrderServiceDetail record);

    int insertSelective(OrderServiceDetail record);

    OrderServiceDetail selectByPrimaryKey(Long orderServiceDetailId);

    int updateByPrimaryKeySelective(OrderServiceDetail record);

    int updateByPrimaryKey(OrderServiceDetail record);
    
    OrderServiceDetail getEstimateOrderServiceDetailByOrderId(Long orderId);
}