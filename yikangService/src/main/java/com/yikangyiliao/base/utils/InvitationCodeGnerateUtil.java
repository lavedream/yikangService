package com.yikangyiliao.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.yikangyiliao.pension.entity.User;

/**
 * @author liushuaic
 * @date 2015/11/18 14:40
 * @desc 邀请码生成工具类
 * */
public class InvitationCodeGnerateUtil{

	/**
	 * @author liushuaic
	 * @date 2015/11/18 14:53
	 * @desc  生成邀请码
	 * 格式： 15（年）+01（月）+18（日）+id
	 * */
	public static Integer generateInvitationCode(User user){
		Date date=Calendar.getInstance().getTime();
		SimpleDateFormat sdf2=new SimpleDateFormat("YYMMdd");
		String dateStr= sdf2.format(date);
		return Integer.valueOf(dateStr+user.getUserId().toString());
	}
	
	
}
