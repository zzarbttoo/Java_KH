<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>결과</h1>
	
	학생 이름 : ${score.name }<br/>
	<jsp:useBean id= "score" class ="com.my.dto.Score" scope ="session"></jsp:useBean>
	<jsp:getProperty property ="name" name ="score"/>

</body>
</html>