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
		<h3>upload form</h3>
		
		file<br/>
		<input type = "file" name = "mpfile"/><br/>
		<p style = "color:red; font-weight:bold;">
			<form:errors path = "mpfile"></form:errors>
		</p><br/>
		description<br/>
		<textarea rows="10" cols ="60" name = "desc"></textarea><br/>
		<input type = "submit" value = "send"/>
	</form:form>

	<!-- 
		form tag의 enctype 속성
		1. application/www-form-urlencoded : 문자들이 encoding 됨 (default)
		2. multipart/form-data : file upload (post)
		3. text/plain : encoding 하지 않음
	
		spring form : tag
			form:form, form:input, form:errors, ...
			form:errors - Errors, BindingResult 를 사용할 때 
			command 객체의 특정 field에서 발생하는 에러 메시지 출력 가능
			
			
			
			
	
	 -->

</body>
</html>