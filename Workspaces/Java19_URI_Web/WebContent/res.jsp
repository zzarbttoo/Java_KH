<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>

		<%=request.getParameter("qname")%>님의 주소는
		<%=request.getParameter("qaddr")%>
		입니다.
	</h1>


</body>
</html>