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
	
	<form action = "logincontroller.jsp" method ="post">
		<table border = "1">
		<col width = "100">
		<col width = "100">
		<col width = "100">
		<col width = "100">
		<col width = "100">
		<col width = "100">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
		
		<tr>	
			<td><input type = "text" name ="id"/></td>
			<td><input type = "text" name = "password"/></td>
			<td><input type = "text" name = "name"/></td>
			<td><input type = "text" name = "address"/></td>
			<td><input type = "text" name = "phone"/></td>
			<td><input type ="text" name = "email"/></td>
		</tr>
		
		
		<tr>	
			<td colspan = "8" align="right">
				<input type ="button" value ="취소" onclick = ""/>
				<input type ="submit" value = "제출" />
			
			</td>
		</tr>
		</table>
		
		
	
	</form>


</body>
</html>