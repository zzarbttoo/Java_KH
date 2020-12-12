package com.what.the;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objectMapper = new ObjectMapper();

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		

		String url = "http://127.0.0.1:5000/";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hi", "hello");
		String body = null;
		
		
		try {
			 body = objectMapper.writeValueAsString(params);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(body!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			
			HttpEntity entity = new HttpEntity(body, headers);
			
			//appId와 Access key 처리를 해줘야한다
			ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
			
			System.out.println(response);
		}
		
		return "home";
	}
	
}
