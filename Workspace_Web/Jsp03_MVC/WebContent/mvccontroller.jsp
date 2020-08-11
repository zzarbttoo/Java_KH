<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mvc.biz.MVCBoardBiz"
	import="com.mvc.biz.MVCBoardBizImpl" import="com.mvc.dto.MVCBoardDto"
	import="java.util.List"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String command = request.getParameter("command");
	MVCBoardBiz biz = new MVCBoardBizImpl();
	System.out.println("<" + command + ">");

	/*
	 	Controller에서 할 일!!
	 	1. (만일 이전 페이지에서 값을 전달했다면) 값 받아주기
	 	2. (만일 db와 연결해야 한다면) db와 연결하기
	 	3. (만일 다음 페이지에 값을 전달해야 한다면) request에 값 저장하기
	 	4. 페이지 이동하기
	*/

	if (command.equals("list")) {
		// 1. X
		// 2. db 연결
		List<MVCBoardDto> list = biz.selectList();
		// 3. 값 전달
		request.setAttribute("list", list);
		// 4. 페이지 이동
		pageContext.forward("mvclist.jsp");

	} else if (command.equals("insertform")) {
		// 1. x
		// 2. x
		// 3. x
		// 4. 페이지 이동
		response.sendRedirect("mvcinsert.jsp");
	} else if (command.equals("insertres")) {

		//1. 값 받아주기 
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MVCBoardDto dto = new MVCBoardDto(writer, title, content);

		//2. db와 연결하기
		if (biz.insert(dto)) {
			// 3. x
			// 4.
	%>
	<script type="text/javascript">
		alert("글작성 성공");
		location.href = "mvccontroller.jsp?command=list";
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("글 작성 실패");
		location.href = "mvccontroller.jsp?command=insertform";
	</script>

	<%
		}

	} else if (command.equals("update")) {

	} else if (command.equals("updateres")) {

	} else if (command.equals("delete")) {

		System.out.println("잘된거맞냐");
		//1.
		int seq = Integer.parseInt(request.getParameter("seq"));

		System.out.println(seq);
		
		//3. 
		if (biz.delete(seq)) {
	%>
		<script type = "text/javascript">
			alert("삭제 성공");
			location.href="mvccontroller.jsp?command=list";
		</script>
	
	
	<%
		} else {
	%>
		<script type = "text/javascript">
			alert("삭제 실패");
			location.href="mvccontroller.jsp?command=delete";
		</script>
	
	<%
		}

	} else if (command.equals("detail")) {

		//1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		//2. 
		MVCBoardDto dto = biz.selectOne(seq);
		//3. 
		request.setAttribute("dto", dto);
		//4. 
		pageContext.forward("mvcdetail.jsp");

	}
	%>

	<h1 style="color: red;">잘못왔따!!</h1>

</body>
</html>