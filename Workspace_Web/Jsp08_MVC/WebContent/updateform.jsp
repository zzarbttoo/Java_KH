<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<jsp:useBean id="dto" class="com.mvc.model.dto.MVCBoardDto"
		scope="request"></jsp:useBean>
	<form action="mvccontroller.do?command=updateres" method = "post">
		<table border="1">
			<tr>
				<th>번호</th>
				<td><input type="text"
					value="<jsp:getProperty property="seq" name="dto" />" name="seq" /></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text"
					value="<jsp:getProperty property="writer" name="dto" />"
					name="writer" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text"
					value="<jsp:getProperty property="title" name="dto" />"
					name="title" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content"
					value="<jsp:getProperty
							property="content" name="dto" />" /></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><jsp:getProperty property="regdate" name="dto" /></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정"
					onclick="" /> <input type="button" value="목록" onclick="" /></td>
			</tr>
		</table>
	</form>
</body>
</html>