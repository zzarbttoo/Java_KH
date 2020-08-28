package com.cal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.dao.CalDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CalCountAjax
 */
@WebServlet("/CalCountAjax.do")
public class CalCountAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String id= request.getParameter("id");
			String yyyyMMdd = request.getParameter("yyyyMMdd");
			
			System.out.println("id" + id);
			System.out.println("yyyyMMdd" + yyyyMMdd);
			
			CalDao dao = new CalDao();
			
			int count = dao.calendarViewCount(id, yyyyMMdd);
			System.out.println("일정 갯수" + count);
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("calCount", count);
			
			//map을 json으로 변환
			JSONObject obj = JSONObject.fromObject(map);
			//응답할 객체에 값 저장할 준비
			PrintWriter out = response.getWriter();
			//json 객체에 구현되어있는 write 메소드를 사용하여
			//json 객체를 응답
			obj.write(out);
			
			
			
	}

}
