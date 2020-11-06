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

	<h1>RESULT</h1>

	page: <%=pageContext.getAttribute("pageContext") %><br/>
	request : <%=request.getAttribute("request") %><br/>
	session : <%=session.getAttribute("session") %><br/>
	application : <%=application.getAttribute("application") %>	<br/>

	<br/>


</body>
</html>