<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.answer.model.dto.*"%>
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
<%
	AnswerDto dto = (AnswerDto) request.getAttribute("dto");
%>
<body>
	<table>
		<tr>
			<th>작가</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea readonly = "readonly" rows = "8" cols = "10"><%=dto.getContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan = "2">
			<button onclick="location.href='answer.do?command=delete&boardno=<%=dto.getBoardno() %>'">삭제</button>
			<button onclick = "location.href='answer.do?command=update&boardno=<%=dto.getBoardno()%>'">수정</button>
			</td>
		</tr>




	</table>



</body>
</html>