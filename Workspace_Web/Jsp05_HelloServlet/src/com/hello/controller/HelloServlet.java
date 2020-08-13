package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String initParameter;
	private String contextParameter;

	/**
	 * Default constructor.
	 */
	public HelloServlet() {

		System.out.println("HelloServlet 객체 생성");

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet init()");

		contextParameter = config.getServletContext().getInitParameter("url");
		initParameter = config.getInitParameter("driver");

		System.out.println("context param : " + contextParameter);
		System.out.println("init param : " + initParameter);
	}

	// get 방식으로 요청시
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Get 방식으로 들어옴");
		doPost(request, response);
	}

	// post 방식으로 요청시
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post방식으로 들어옴");

		// 인코딩부터 잡아야한다
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		PrintWriter out = response.getWriter();
		out.print("<h1 style = 'background-color : skyblue;'>Hello, Servlet!</h1>");
		out.print("<h2>계층구조/라이프사이클/url맵핑</h2>");
		out.print("<a href='home.html'>돌아가기</a>");

	}

	@Override
	public void destroy() {
		
		System.out.println("Servlet destroy!!");
		
	}

}
