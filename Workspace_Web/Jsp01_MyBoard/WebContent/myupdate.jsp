<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.my.dao.MyBoardDao" import="com.my.dto.MyBoardDto"%>
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
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);
	%>

	<h1>Update</h1>
	<form action="myupdateres.jsp" method="post">
		<input type = "hidden" name = "myno" value = "<%=dto.getMyno()%>"/>
		<table border="1">
			<tr>
				<th>이름</th>
				<td><%=dto.getMyname() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name  ="mytitle" value="<%=dto.getMytitle() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols= "60" name = "mycontent"><%=dto.getMycontent() %></textarea></td>
			</tr>
			<tr>
			<td colspan = "2" align = "right">
				<input type = "button" onclick = "" value = "취소" />
				<input type = "submit" value = "수정"/>
			</td>
			</tr>

		</table>

	</form>



</body>
</html>