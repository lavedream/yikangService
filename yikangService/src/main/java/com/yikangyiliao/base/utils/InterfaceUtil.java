package com.yikangyiliao.base.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


/**
 * @author liushuaic
 * @date 2015/07/24 12:19
 * */
public class InterfaceUtil {
	
	
	private static Map<String,String> serviceClassName=null;
	
	private static Map<String,String> mathodClassPath=null;
	
	static{
		serviceClassName=new HashMap<String,String>();
		mathodClassPath=new HashMap<String,String>();
		serviceClassName.put("0-0","test");
		mathodClassPath.put("0-0-1","test");
		
		serviceClassName.put("00-01", "seniorAccountService");
		mathodClassPath.put("00-01-01","saveSeniorAccount");
		mathodClassPath.put("00-01-02","getSeniorAccountById");
		
		//量表
		serviceClassName.put("00-02", "scaleService");
		//档案袋
		mathodClassPath.put("00-02-01", "saveAssessment");
		//感知与沟通 
		mathodClassPath.put("00-02-02", "savePerceptionCommunications");
		//社会参与
		mathodClassPath.put("00-02-03", "saveSocialParticipation");
		//日常生活
		mathodClassPath.put("00-02-04", "saveDailyIndexe");
		//精神状态
		mathodClassPath.put("00-02-05", "saveMentalIndexes");
		
		
		
		/**
		 * 生活护理评估
		 * */
		serviceClassName.put("00-03", "lifeNurseAssessmentService");
		mathodClassPath.put("00-03-01", "getQuestionCrosswiseByTableName");
		mathodClassPath.put("00-03-02", "getQuestionUnitAnswerMapByQuetionCrosswiseId");
		
		
		serviceClassName.put("00-04", "answerService");
		mathodClassPath.put("00-04-01", "saveAnswer");
		
	}
	
	public void loadConfigInterface(String filePath){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
			SAXParser saxParser = factory.newSAXParser();
	        InputStream is = InterfaceUtil.class.getClassLoader()
	                .getResourceAsStream("student.xml");
	        //saxParser.parse(is);
	        // TODO 后期添加本功能
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 *
	 *@author liushuaic
	 *@date 2015/07/24 15:33
	 *@desc 返回serviceName
	 *
	 ***/
	public static String getBeanNameByServiceCode(String serviceCode){
		serviceCode=serviceCode.substring(0,serviceCode.lastIndexOf('-'));
		return serviceClassName.get(serviceCode);
	}

	
	/***
	 *@author liushuaic
	 *@date 2015/07/24 15:32
	 *返回方法名称
	 * */
	public static String getMethodNameByServiceCode(String serviceCode){
		return mathodClassPath.get(serviceCode);
	}
	
	
	public static void main(String[] args) {
		String codeStr="00-02-01";
		System.out.println(codeStr.substring(0,codeStr.lastIndexOf('-')));
	}
	
	
}
