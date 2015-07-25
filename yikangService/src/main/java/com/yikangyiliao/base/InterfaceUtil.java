package com.yikangyiliao.base;

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
		serviceClassName.put("0-0-1","test");
		mathodClassPath.put("0-0-1","test");
	}
	
	public void loadConfigInterface(String filePath){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
			SAXParser saxParser = factory.newSAXParser();
	        InputStream is = InterfaceUtil.class.getClassLoader()
	                .getResourceAsStream("student.xml");
	        //saxParser.parse(is);
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
}
