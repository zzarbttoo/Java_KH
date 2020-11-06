package com.pstm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayingDo
 */
@WebServlet("/pay.do")
public class PayingDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doPost(request, response);
   		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("어디 문제냐 ");
		
		String command = request.getParameter("command");
		
		if(command.equals("subscription")) {
			
			String pg=request.getParameter("pg");
			request.setAttribute("pg", pg);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("pstm_subscription.jsp");
			dispatch.forward(request, response);
			
		}else if(command.equals("temptest")) {
			
			System.out.println("testtemp");
		}
		
	}

}
