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

	<h1>jsp:useBean</h1>
	
	<jsp:useBean id = "score" class ="com.my.dto.Score" scope="session"></jsp:useBean>
	<!-- Score score = new Score(); -->

	<jsp:setProperty property ="name" name ="score" value ="홍길동"/>
	<!-- score.setName("홍길동") -->
	
	<jsp:setProperty property = "kor" name ="score" value ="100"/>
	<!-- score.setKor(100); -->
	
	<jsp:getProperty property = "name" name ="score"/>
	<!-- score.getName(); -->
	
	<a href="result.jsp">결과</a>
	
</body>
</html>