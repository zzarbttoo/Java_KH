package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.biz.MVCBoardBiz;
import com.mvc.model.biz.MVCBoardBizImpl;
import com.mvc.model.dto.MVCBoardDto;

@WebServlet("/mvccontroller.do")
public class MVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MVCServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		String command = request.getParameter("command");
		System.out.printf("[%s]\n", command);

		MVCBoardBiz biz = new MVCBoardBizImpl();

		if (command.equals("list")) {

			// 2.
			List<MVCBoardDto> list = biz.selectList();
			// 3.
			request.setAttribute("list", list);
			// 4.
			dispatch("boardlist.jsp", request, response);

		} else if (command.equals("detail")) {

			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch("boarddetail.jsp", request, response);

		} else if (command.equals("updateform")) {

			int seq = Integer.parseInt(request.getParameter("seq"));

			MVCBoardDto dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch("updateform.jsp", request, response);

		} else if (command.equals("updateres")) {

			int seq = Integer.parseInt(request.getParameter("seq"));
			String content = request.getParameter("content");
			String title = request.getParameter("title");

			MVCBoardDto dto = new MVCBoardDto(seq, content, title);
			int res = biz.update(dto);
			System.out.println(res);

			if (res > 0) {

				System.out.println("수정 성공");
				jsResponse("글 수정 성공", "mvccontroller.do?command=list", response);

			}else {
				
				
				jsResponse("글 수정 실패", "mvccontroller.do?command=list", response);
				
			}

		} else if (command.equals("insertform")) {

			// 그냥 이동하는 코드
			response.sendRedirect("boardinsert.jsp");

		} else if (command.equals("insertres")) {

			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			int res = biz.insert(new MVCBoardDto(writer, title, content));

			System.out.println("여기 되는거 맞냐냐냐");
			System.out.println(res);
			if (res > 0) {
				// f5(새로고침) 누르면 다시 계속 저장되는 코드
				/*
				 * List<MVCBoardDto> list = biz.selectList(); request.setAttribute("list",
				 * list); dispatch("boardlist.jsp", request, response);
				 */
				//그냥 이동하는 코드
				// response.sendRedirect("mvccontroller.do?command=list");
				// alert 출력하고 이동하는 코드
				jsResponse("글 추가 성공", "mvccontroller.do?command=list", response);

			} else {
				//그냥 가는 코드
				//response.sendRedirect("insertres.jsp");
				jsResponse("글 추가 실패", "mvccontroller.do?command=insertform", response);
			}
		}else if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.delete(seq);
			if(res > 0) {
				
				jsResponse("글 삭제 성공", "mvccontroller.do?command=list", response);
			}else {
				
				jsResponse("글 삭제 실패", "mvccontroller.do?command=list", response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// forward 해야하는 상황이 많아서 메소드로 따로 뺐다(중복되는 코드는 모아서 분류해줘야한다)
	// 경로와 request, response 객체를 받았다
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	// alert 띄운 후(msg), 어디로 가라, javascript 를 응답할 것이다(HttpServletResponse response)
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		//한줄로 써서 ''를 붙이지만, 여러 줄로 써도 어차피 한줄로 컴파일 되므로 붙여줘야한다 
		String res ="<script>alert('"+msg+"'); location.href='"+url+"';</script>";
		
		out.print(res);
	}

}
