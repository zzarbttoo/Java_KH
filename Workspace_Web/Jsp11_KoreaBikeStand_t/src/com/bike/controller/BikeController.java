package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/bike.do")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
	
		if (command.equals("view")) {
			response.sendRedirect("view.html");
		
		} else if (command.equals("getdata")) {
			
			BikeDao dao = new BikeDao();
			
			if(dao.delete()) {
				
				System.out.println("db 초기화 성공");
				
			}else {
				
				System.out.println("db 초기화 실패");
				
			}
			String data = request.getParameter("data");
			// System.out.println(data);
			
			//JsonElement : JsonObject/JsonArray / JsonPrimitive / JsonNull(얘는 어쨋든 json 객체야)
			//JsonObject : {"name" : JsonElement} -> json 객체 (얘는 key:value} 형태로 돼있는 애야!
			
			//JsonString을 JsonElement parsetree로 만들었다
			JsonElement element = JsonParser.parseString(data);
			
			//getAsJsonObject : element를 jsonObject로 만들어준다
			JsonObject jsonData = element.getAsJsonObject();
			//.get("string") 멤버를 특정 이름으로 리턴해준다
			JsonElement records = jsonData.get("records");
			//받은 element를 JsonArray로 저장해준다
			JsonArray recordsArray = records.getAsJsonArray();
			
			
			JsonArray resultArray = new JsonArray();
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			
			for (int i = 0 ; i < recordsArray.size() ; i++) {
				//get(i) <- array의 i번째 element return
				//.getAsString() : 배열 내에 element가 하나 있을 경우 array를 String으로 받아와준다
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				
				if (recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
				}
				
				Double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				Double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();

				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				
				list.add(dto);
				
				System.out.println(dto);
				
				
				//gson 객체 생성
				Gson gson = new Gson();
				
				//target을 json으로 직렬화serialize 한다
				//직렬화 : object와 data를 byte 형태로 바꿔 외부에서도 사용 가능하게 한다
				String jsonString = gson.toJson(dto);
				System.out.println(i + jsonString);
				
				resultArray.add(JsonParser.parseString(jsonString));
			}
			
			
			System.out.println(resultArray);
			JsonObject result = new JsonObject();
			result.add("result", resultArray);
			
			System.out.println(list);
			if(dao.insert(list)) {
				
				System.out.println("db 저장 성공");
				
			}else {
				System.out.println("db 저장 실패");
				
			}
			
			response.getWriter().append(result+"");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}


































