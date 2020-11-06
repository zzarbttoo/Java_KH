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
	<%
	
	Exception e = (Exception)request.getAttribute("error");
	%>
	
	<h1 style="color : red;">ERROR!!!</h1>
	<p><%=e.getMessage() %></p>
	<a href = "index.jsp">HOME</a>
	<a href = "javascript:history.back()">이전페이지로 이동</a>


</body>
</html>