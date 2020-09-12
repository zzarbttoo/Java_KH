package com.pstm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pstm.biz.PagingTestBiz;
import com.pstm.dao.PagingTestDao;
import com.pstm.dto.PagingTestDto;
import com.pstm.paging.PagingTest;

@WebServlet("/PagingTServlet")
public class PagingTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPageNo = 1;
		int recordPerPage = 3;
		
		//biz로 하는데 왜 안되냐
		//PagingTestBiz pagingbiz = new PagingTestBiz();
		
		PagingTestDao pagingdao = new PagingTestDao();
		
		if(request.getParameter("pages") != null) {
			currentPageNo = Integer.parseInt(request.getParameter("pages"));
		}
		
		/*
		if(request.getParameter("lines")!=null) {
			
			recordPerPage = Integer.parseInt(request.getParameter("lines"));
			
		}
		*/
		
		PagingTest paging = new PagingTest(currentPageNo, recordPerPage);
		
		// 수정
		paging.setRecordsPerPage(3);
		int offset = (paging.getCurrentPageNo() - 1)*paging.getRecordsPerPage();
		System.out.println(offset + "," +  recordPerPage);
		
	//	List<PagingTestDto> pagingtestlist = pagingbiz.selectAllTestPaging(offset, recordPerPage);
		
		List<PagingTestDto> pagingtestlist = pagingdao.selectAllTestPaging(offset, recordPerPage);
		int getnoforecord = pagingdao.getNoFoRecord();
		System.out.println(pagingtestlist);
		System.out.println(getnoforecord);
		
		for (PagingTestDto testdto : pagingtestlist) {
			
			System.out.println(testdto.getRn());
		}
		paging.setNumberOfRecords(getnoforecord);
		paging.makePaging();
		
		request.setAttribute("paging", paging);
		request.setAttribute("pagingtestlist", pagingtestlist);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("pstm_pagedemo.jsp");
		dispatch.forward(request, response);
		
	}

}
