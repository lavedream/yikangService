package com.yikangyiliao.pension.schedule;

import java.util.Calendar;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.entity.AppointmentOrder;
import com.yikangyiliao.pension.entity.OrderServiceDetail;
import com.yikangyiliao.pension.manager.AppointmentOrderManager;
import com.yikangyiliao.pension.manager.OrderServiceDetailManager;

/**
 * @author liushuaic
 * @date 2015/10/09 19:28 
 * @desc 人员自动分配
 * 
 * */

@Component
public class PersonnelDistribution implements Runnable{
	
	public ArrayBlockingQueue<Long> orderIdsQueue=new ArrayBlockingQueue<Long>(30000);
	
	@Autowired
	private AppointmentOrderManager appointmentOrderManager;
	
	@Autowired
	private OrderServiceDetailManager orderServiceDetailManager;
	
	
	public void run() {
		
		 while (true) {
			 try{
					 Long val=orderIdsQueue.take();

					 AppointmentOrder appointmentOrder=appointmentOrderManager.getAppointmentOrderByOrderId(val);
					 //appointmentOrder.getDetailAddress();
					 //1.查询出来所有，有空余时间的人
					 //2.查询出来，定单的地址，与  坐标信息
					 //3.匹配出距离近的。可以是最近一单，距离最近的。
					
					 //1.获取服务定单
					 OrderServiceDetail orderServiceDetail= orderServiceDetailManager.getEstimateOrderServiceDetailByOrderId(val);
					 orderServiceDetail.setServiceUserId(18l);
					 orderServiceDetail.setUpdateTime(Calendar.getInstance().getTimeInMillis());
					 orderServiceDetailManager.updateOrderServiceDetailSelective(orderServiceDetail);
			 	} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 }
		 
		 
	}
	

}
