package com.scope.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScopeServlet() {

		System.out.println("ScopeController 생성!!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//처음 받으면 인코딩 설정부터 하기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		//page X
		
		//request
		String requestVal =(String) request.getAttribute("request");
		System.out.println("request : " + requestVal);
		//request parameter
		System.out.println("request param : " + request.getParameter("req"));
		
		
		//session
		HttpSession session = request.getSession();
		String sessionVal = (String) session.getAttribute("session");
		System.out.println("session : " + sessionVal);
		
		//application
		ServletContext application = getServletContext();
		String applicationVal = (String) application.getAttribute("application");
		System.out.println("application : " + applicationVal);
		
		//포워드는 jsp내장 객체이므로 서블릿에서 쓰려면 다음과 같이 써야한다
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		request.setAttribute("request", "scope is very hard" );
		dispatch.forward(request, response);
	}

}
