<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");
	
/*
	데이터가 변경되었을 때, 이전 내용을 화면에 보여주는 이유
	->서버 리턴값이 아닌 캐시에 저장된 값을 가져오기 때문
	
	브라우저가 캐시에 응답결과를 저장하지 않도록 설정
	response.setHeader("Pragma", "no-cache"); // http 1.0
	response.setHeader("Cache-control", "no-store"); http 1.1
	response.setHeader("Expires", "0"); //proxy server
*/

%>

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
	if(dto == null){
		
		pageContext.forward("index.jsp");
		
	}
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