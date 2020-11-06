package com.cal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class CalServlet
 */
@WebServlet("/cal.do")
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math= Integer.parseInt(request.getParameter("math"));
		
		int sum = kor + math + eng;
		double avg = (double) sum / 3;
		
		// json.simple-1.1.1.jar <- map 형태로 값을 넣어 줄 것이다
		
		//json 형태의 자바 객체
		JSONObject obj = new JSONObject();
		//map 형태로 집어넣었다
		obj.put("name", name);
		obj.put("sum",sum);
		obj.put("avg", avg);
		
		PrintWriter out = response.getWriter();
		//toJSONString은 json object를 문자열로 바꿀거야 아니면 객체가 그대로 프린트 되기 때문에 json 형태의 string으로 바꿔 출력할 것이다
		//json이 아니라 json 형태의 문자열 
		
		//pringWriter out 이므로 리턴이 된다
		out.println(obj.toJSONString());
		
		
		System.out.println("servlet에서 보내는 json data:" + obj.toJSONString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
