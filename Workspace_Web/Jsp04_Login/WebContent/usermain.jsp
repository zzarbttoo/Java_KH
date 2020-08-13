<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import= "com.login.dto.*"
 %>
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
	MYDto dto = (MYDto) session.getAttribute("login");

%>

	<h1>USER MAIN</h1>
	
	
	<div>
		<span><%=dto.getMyid() %>님 환영합니다. (등급 : <%=dto.getMyrole()%> )</span>
		<a href = "logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	<div>
		<a href = "logincontroller.jsp?command=detail&myno=<%=dto.getMyno()%>">내 정보 보기</a>
	</div>
</body>
</html>