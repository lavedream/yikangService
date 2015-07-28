package com.yikangyiliao.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikangyiliao.base.encryption.AES;



@Controller
public class ServiceController {

	private ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/service/{serverviceCode}")
	@ResponseBody
	public Map<String,Object> doMethod(@PathVariable String serverviceCode, String paramData) {
		// String code="test";

		if (null != serverviceCode) {

			Map<String, Object> rtnMap = new HashMap<String, Object>();

			String beanName = InterfaceUtil.getBeanNameByServiceCode(serverviceCode);

			String methodName = InterfaceUtil.getMethodNameByServiceCode(serverviceCode);

			if (null != beanName) {
				if (null != methodName) {

					Object invokObject = ApplicationContextUtil.applicationContext.getBean(beanName);

					try {
						Method returnMethod = invokObject.getClass().getMethod(
								methodName, Map.class);

						Map<String, Object> paramMap = new HashMap<String, Object>();
						if(null != paramData && paramData.length()>0){
							paramData=AES.Decrypt(paramData, "1234567890abcDEF");
							paramMap=objectMapper.readValue(paramData, Map.class);
						}
					
						rtnMap = (Map<String, Object>) returnMethod.invoke(invokObject, paramMap);

						// 获取返回
						if(null != rtnMap.get("data")){
							Object data = rtnMap.get("data");

							String jsonStr = objectMapper.writeValueAsString(data);
							String enStr = AES.Encrypt(jsonStr, "1234567890abcDEF");

							rtnMap.put("data", enStr);
						}


						//return objectMapper.writeValueAsString(rtnMap);
						return rtnMap;

					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonGenerationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			//return "{status:'999999',message:'没有对应的服务！',data:''}";
		}
		//return "{status:'999999',message:'易康现在有点忙！',data:''}";
		return null;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String doMethodw2(ModelMap map, HttpServletRequest request) {

		return "{status:'999999',message:'易康现在有点忙！',data:''}";
	}

}
