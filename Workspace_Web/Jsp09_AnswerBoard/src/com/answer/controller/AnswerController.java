package com.answer.controller;

import java.io.IOException;
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

@WebServlet("/AnswerController")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 처음에는 인코딩부터
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		String command = request.getParameter("command");
		AnswerBiz biz = new AnswerBizImpl();

		try {
			if (command.equals("list")) {

				List<AnswerDto> list = biz.selectList();
				request.setAttribute("list", list);

				dispatch("boardlist.jsp", request, response);
			} else if (command.equals("detail")) {

				int boardno = Integer.parseInt(request.getParameter("boardno"));
				AnswerDto dto = biz.selectOne(boardno);

				request.setAttribute("dto", dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			dispatch("error.jsp", request, response);
		}
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {

		String result = "<script>alert(\"" + msg + "\"); location.href=\"" + url + "\"; </script>";

		// out.println과 같은 메소드이다
		response.getWriter().append(result);

	}

}
