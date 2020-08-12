<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.login.dto.*"
 %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MYDto dto = (MYDto) session.getAttribute("login");
%>
<body>

	<h1>ADMIN MAIN PAGE</h1>

	<div>
		<span><%=dto.getMyid() %> 님 환영합니다</span>
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	
	<div>
		<div>
			<a href="logincontroller.jsp?command=listall">회원 정보 전체 조회</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=listenabled">가입된 회원 조회</a>
		</div>
	</div>
	
</body>
</html>