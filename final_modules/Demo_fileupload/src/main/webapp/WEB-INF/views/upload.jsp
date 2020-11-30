<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method = "post" enctype = "multipart/form-data" modelAttribute = "uploadFile" action = "upload">
	
		<h1>upload form</h1>
		
		<input type = "file" name = "mpfile"/><br/>
		<p style = "color:red; font-weightLbold;">
			<form:errors path = "mpfile"></form:errors>
		</p>
		<textarea rows = "10" cols = "60" name = "desc"></textarea>
		<input type = "submit" value = "send"/>
	</form:form>

</body>
</html>