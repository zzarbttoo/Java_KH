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
		AnswerDto parentDto = (AnswerDto) request.getAttribute("dto");
		System.out.println("DEBUG3");
		System.out.println(parentDto.getBoardno());
	%>
	<form action="answer.do" method="post">
		<input type="hidden" name="boardno"
			value="<%=parentDto.getBoardno()%>" /> <input type="hidden"
			name="command" value="subinsertres" />
		<input type ="hidden" name = "groupseq" value = "<%=parentDto.getGroupseq() %>"/>
		<table>
			<tr>
				<th>제목</th>
				<td><input type ="text" name = "title" /></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type = "text" name = "writer"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type = "text" name = "content"/></td>
			</tr>

			<tr>
				<td colspan = "2">
					<button type = "submit">제출</button>
				</td>
			</tr>
		</table>

	</form>


</body>
</html>