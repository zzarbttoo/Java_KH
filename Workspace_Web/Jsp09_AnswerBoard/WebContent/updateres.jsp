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
<body>
	<%
		AnswerDto dto = (AnswerDto) request.getAttribute("dto");
	%>

	<form action="answer.do" method="post">
		<input type = "hidden" name = "boardno" value= "<%=dto.getBoardno() %>"/>
		<input type = "hidden" name = "command" value= "updateres"/>
		<table>
			<tr>
				<th>작가</th>
				<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "title" value =" <%=dto.getTitle()%>"/></td>
			</tr>

			<tr>
				<th>내용</th>
				<td><input type ="text" name = "content" value=" <%=dto.getContent()%>"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type = "submit">제출</button>
				</td>
			</tr>
		</table>



	</form>

</body>
</html>