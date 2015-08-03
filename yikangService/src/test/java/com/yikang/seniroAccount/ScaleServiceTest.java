package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ScaleServiceTest {

	
	
	@Test
	public void testSaveAssement() {
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("assessmentName", "hello");
			paramData.put("seniorId", 1);

			SendRequest.sendPost("00-02-01", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
