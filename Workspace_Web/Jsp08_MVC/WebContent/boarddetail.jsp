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

	<h1>선택</h1>
	<jsp:useBean id="dto" class="com.mvc.model.dto.MVCBoardDto"
		scope="request"></jsp:useBean>
	<table border="1">
		<tr>
			<th>번호</th>
			<td><jsp:getProperty property="seq" name="dto" /></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><jsp:getProperty property="writer" name="dto" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><jsp:getProperty property="title" name="dto" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows ="10" cols = "60" readonly = "readonly"><jsp:getProperty property="content" name="dto" /></textarea></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><jsp:getProperty property="regdate" name="dto" /></td>
		</tr>
		
		<tr>
		<td colspan = "2" align = "right">
			<input type = "button" value = "수정" onclick = "location.href='mvccontroller.do?command=updateform&seq=<jsp:getProperty property = "seq" name = "dto" />'"/>
			<input type = "button" value = "삭제" onclick = "location.href='mvccontroller.do?command=delete&seq=<jsp:getProperty property = "seq" name = "dto"/>'"/>
			<input type = "button" value = "목록" onclick = "" />
		</td>
		</tr>
	</table>
	
	
</body>
</html>