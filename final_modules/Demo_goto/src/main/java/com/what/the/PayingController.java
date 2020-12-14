package com.what.the;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class PayingController {
	
	
	@RequestMapping("/paying.do")
	public String paying() {
		
		return "paying";
		
	}
	
	@RequestMapping("/payingRes.do")
	public void payingRes(Test test, String jsonData) {
		
		
		System.out.println(jsonData);
		//꼭 object로 주지 않아도 상관 없는 듯 하다 
		System.out.println(test.getTestword());
		
		// Apache HttpClient기반의 java용 아임포트 REST API클라이언트
		IamportClient iamportClient = new IamportClient();
		String apiResponse;
			
		ObjectMapper mapper = new ObjectMapper();
		JsonParser parser = new JsonParser();
		
		Map<String, String> ajaxmap;
		Map<String, String> resultMap;
		Map<String, String> realResponse;
		
		String realAmount;
		
		try {
			ajaxmap = mapper.readValue(jsonData, Map.class);
			
			try {
				//System.out.println(iamportClient.paymentByImpUid(map.get("imp_uid")));
				apiResponse = iamportClient.paymentByImpUid(ajaxmap.get("imp_uid"));
				System.out.println(apiResponse);
				System.out.println(apiResponse.getClass());
				
				Object obj = parser.parse(apiResponse);
				JsonObject jsonObj = (JsonObject) obj;
				JsonElement response = jsonObj.get("response");
				realAmount = response.getAsJsonObject().get("amount").getAsString();
				System.out.println(realAmount);
				
				
				
			
				
				
				
				
			
							
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
		
		
		
		
	}

}
