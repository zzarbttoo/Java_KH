package com.my.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dto.Score;


@WebServlet("/my.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html charset = UTF-8");
			
			String command = request.getParameter("command");
			if(command.equals("basic")) {
				
				response.sendRedirect("basic-arithmetic.jsp");
			}else if(command.equals("eltest")) {
				
				Score sc = new Score("홍길동", 100, 99, 88);
				request.setAttribute("dto", sc);
				RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
				dispatch.forward(request, response);
				
			}else if(command.contentEquals("jstltest")) {
				
				List<Score> list = new ArrayList<Score>();
				
				for(int i = 10 ; i< 50; i += 10) {
					
					//이름10, 60, 60, 60
					//이름20, 70, 70, 70
					//이름30, 80, 80, 80
					//이름40, 90, 90, 90
					Score sc = new Score("이름" + i, 50 + i, 50+ i, 50+i);
					list.add(sc);
				}
				
				request.setAttribute("list", list);
				RequestDispatcher dispatch = request.getRequestDispatcher("jstltest.jsp");
				dispatch.forward(request, response);
				
			}else if(command.equals("usebean")) {
				
				response.sendRedirect("usebean.jsp");
				
			}
					

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
