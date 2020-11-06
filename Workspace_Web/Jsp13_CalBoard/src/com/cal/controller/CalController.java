package com.cal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.dao.CalDao;
import com.cal.dto.CalDto;
@WebServlet("/CalController.do")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset = UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		
		CalDao dao = new CalDao();
		
		if(command.equals("calendar")) {
			
			response.sendRedirect("calendar.jsp");
		}else if(command.contentEquals("insertcal")) {
			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");
			//2020122251200 <- 이런 식으로 12자리 나온다
			//원래는 비즈단에서 해결을 해줘야하는데, 한자리수는 08 이런 식으로 바꿔줘야한다
			
			String mdate = year + Util.isTwo(month) + Util.isTwo(date) + Util.isTwo(hour) + Util.isTwo(min);
			
			
			
			
			String id = request.getParameter("id");
			String title= request.getParameter("title");
			String content = request.getParameter("content");
			
			CalDto dto = new CalDto(0, id, title, content, mdate, null);
			
			int res = dao.insertCalBoard(dto);
			if(res > 0) {
				
				response.sendRedirect("CalController.do?command=calendar");
				
			}else {
				
				request.setAttribute("msg", "일정 추가 실패");
				dispatch("error.jsp", request, response);
				
			}
		
		}else if(command.equals("list")) {
			
			String year= request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String yyyyMMdd = year+ Util.isTwo(month) + Util.isTwo(date);
			
			System.out.println("year뜨냐" + year);
			System.out.println("year뜨냐" + month);
			System.out.println("year뜨냐" + date);
			System.out.println("year뜨냐" + yyyyMMdd);
			
			List<CalDto> list = dao.selectCalendarList(yyyyMMdd, "kh");
			
			request.setAttribute("list", list);
			dispatch("listcalboard.jsp", request, response);
			
			
		}
		
		
	}
	

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
