package com.yikangyiliao.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author liushuaic
 * @date 2015/07/29 15:24
 * @desc 日期工具类
 * **/
public class DateUtils {
	
	
	
	/**
	 * @param dataStr 2015-06-25
	 * @return  毫秒
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/07/29 15:42
	 * ***/
	public static Long getＭillisecond(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr).getTime();
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=sdf.parse("2015-07-15");
		System.out.println(d.getTime());
		System.out.println(sdf2.format(sdf.parse("2015-07-15")));
	}

}
