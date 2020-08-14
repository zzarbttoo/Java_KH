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

	<h1>EL TEST</h1>

	<table>
		<tr>
			<th colspan="2">${dto.name }의성적표</th>
			<td></td>
		</tr>
		<tr>	
		 <th colspan = "2">\${dto.name} == &lt;%=dto.getName();%&gt;</th>
		</tr>
		<tr>
			<th>국어</th>
			<td>${dto.kor }</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${dto.eng }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${dto.math }</td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${dto.avg }</td>
		</tr>
	</table>
	
	<jsp:useBean id = "dto" class ="com.my.dto.Score" scope="request"></jsp:useBean>
	<h1><jsp:getProperty property ="name" name ="dto"/></h1>


</body>
</html>