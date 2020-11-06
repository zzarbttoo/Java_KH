<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>REGIST</h1>
	
	<form action = "registres.do" method= "post">
		<table border = "1">
			<tr>
				<th>이름</th>
				<td><input type ="text" name=  "membername"/></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type=  "text" name=  "memberid"/></td>
			</tr>
			<tr>	
				<th>비밀번호</th>
				<td><input type = "text" name = "memberpw"/></td>
			</tr>
			<tr>
				<td colspan = "2" align = "right">
					<input type=  "submit" value = "회원가입"/>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>