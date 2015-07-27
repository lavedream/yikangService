package com.yikang.base;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * @author liushuaic
 * @date 2015/07/27 18:22
 * @发送请求工具类
 * **/
public class SendRequest {

	private static String REQUEST_URL = "http://127.0.0.1:8088/service/";

	public static void sendPost(String serviceCode,String  paramData) throws IOException {
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			HttpGet httpget = new HttpGet(REQUEST_URL+serviceCode+"?paramData="+paramData);

			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						System.out.println(entity.toString());
						return entity != null ? EntityUtils.toString(entity)
								: null;
						
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			SendRequest.sendPost("00-01-01","ssd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
