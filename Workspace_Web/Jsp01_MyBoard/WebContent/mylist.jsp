<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.my.dao.MyBoardDao" import="com.my.dto.MyBoardDto"
	import="java.util.List" import="java.util.ArrayList"%>
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
		MyBoardDto dto = new MyBoardDto();
	MyBoardDao dao = new MyBoardDao();

	List<MyBoardDto> list = dao.select();
	System.out.println(list.size());
	%>

	<table border="1">

		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>

		<%
			for (int i = 0; i < list.size(); i++) {
		%>


		<tr>
			<td><%=list.get(i).getMyno()%></td>
			<td><%=list.get(i).getMyname()%></td>
			<td><a href="myselect.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle()%></a></td>
			<td><%=list.get(i).getMycontent()%></td>
			<td><%=list.get(i).getMydate()%></td>
		</tr>


		<%
			}
		%>

		<tr>
			<td colspan = "4" align = "right">
				
				<button type="button" onclick ="location.href='myinsert.jsp'">글쓰기</button>
			</td>
		</tr>

	</table>
	









</body>
</html>