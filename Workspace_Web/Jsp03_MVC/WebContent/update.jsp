<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.mvc.dto.*" import="com.mvc.biz.*"%>
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
		MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
	%>
	
<h1>UPDATE</h1>
	<form action="mvccontroller.jsp" method = "post">
		<input type = "hidden" name = "command" value = "updateres"/>
		<input type = "hidden" name = "seq" value = "<%=dto.getSeq()%>"/>
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type = "text" value = "<%=dto.getWriter()%>" name = "writer"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" value = "<%=dto.getTitle()%>" name = "title"/></td>
				
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols ="60" name = "content"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<td>
					<input type = "button" value ="취소" onclick=""/>
					<input type = "submit" value ="확인"/>
				</td>
			</tr>


		</table>


	</form>







</body>
</html>