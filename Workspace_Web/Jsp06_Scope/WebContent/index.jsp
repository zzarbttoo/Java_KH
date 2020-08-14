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
	//scope 객체들
	pageContext.setAttribute("pageContext", "my pageContext value");
	request.setAttribute("request", "my request value");
	session.setAttribute("session", "my session value");
	application.setAttribute("application", "my application vlaue");
%>

	<h1>INDEX</h1>

	page: <%=pageContext.getAttribute("pageContext") %><br/>
	request : <%=request.getAttribute("request") %><br/>
	session : <%=session.getAttribute("session") %>><br/>
	application : <%=application.getAttribute("application") %><br/>
	

	
	<a href ="result.jsp">result</a>
	<br/>
	<a href = "scope.do">servlet</a>
	<br/>
	<a href = "scope.do?req=hard">servlet param</a>
	<br/>
	<form action = "scope.do" method = "post">
		<input type = "hidden" name = "req" value = "hard2"/>
		<input type = "submit" value = "servlet param"/>
	</form>

</body>
</html>