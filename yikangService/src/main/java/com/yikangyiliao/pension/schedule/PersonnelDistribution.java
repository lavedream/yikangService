package com.yikangyiliao.pension.schedule;

import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Component;

/**
 * @author liushuaic
 * @date 2015/10/09 19:28 
 * @desc 人员自动分配
 * 
 * */

@Component
public class PersonnelDistribution implements Runnable{
	
	public ArrayBlockingQueue<Integer> orderIdsQueue=new ArrayBlockingQueue<Integer>(30000);

	public void run() {
		 while (true) {
			 try {
				 System.out.println("ok ------>>>>");
				 Integer val=orderIdsQueue.take();
				 System.out.println(val);
				 if(val==10){
					 break;
				 }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	}
	

}
