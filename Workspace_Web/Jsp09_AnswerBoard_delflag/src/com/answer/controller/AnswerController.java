package com.answer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.model.biz.AnswerBiz;
import com.answer.model.biz.AnswerBizImpl;
import com.answer.model.dto.AnswerDto;

@WebServlet("/answer.ho")

public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		
		AnswerBiz biz = new AnswerBizImpl();
		
		if(command.equals("list")) {
			
			List<AnswerDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			System.out.println(list);
			dispatch(request, response, "boardlist.jsp");

			
			
		}else if(command.equals("insertform")){
			
			response.sendRedirect("boardinsert.jsp");
			
		}else if(command.equals("insertres")){
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.insertBoard(dto);
			
			if(res > 0) {
				
				System.out.println("작성 성공");
				dispatch(request, response, "answer.ho?command=list");
				//jsResponse("글 작성 성공", "answer.ho?command=list", response);
				
			}else {
				
				dispatch(request, response, "answer.ho?command=insertform");
				System.out.println("작성 실패");
				//jsResponse("글 작성 실패", "answer.ho?command=insertform" , response);
				
			}
					
					
		}else if(command.equals("detail")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			System.out.println("여기는 왔겠지");
			
			System.out.println(boardno);
			
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch(request, response, "boarddetail.jsp");
			
		}else if(command.equals("delete")) {
			
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			int res = biz.deleteBoard(boardno);
			if(res > 0) {
				
				dispatch(request, response, "answer.ho?command = list");
			}else {
				
				dispatch(request, response, "answer.ho?command=detail?boardno=" +boardno );
			}
			
		}else if(command.equals("updateform")) {
			
			int boardno = Integer.parseInt("boardno");
			AnswerDto dto = biz.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			dispatch(request, response, "boardupdate.jsp");
			
		}else if(command.equals("updateres")) {
			
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(boardno);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.updateBoard(dto);
			if(res > 0) {
				
				dispatch(request, response, "answer.ho?comand=detail&boardno = " + boardno);
				
			}
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		
		String result = "<script>alert('" + msg+"'); location.href= '"+url+"';<script/>";
		PrintWriter out = response.getWriter();
		out.print(result);
				
		
	}
	
	
	

}
