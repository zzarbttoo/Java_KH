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
	
	<form action ="logincontroller.jsp" method = "post">
		<input type = "hidden" name = "command" value = "login"/>
		
		<table border = "1">
			<col width = "100"/>
			<col width = "100"/>
			<tr>
				<th>I D</th>
				<td><input type = "text" name = "myid"/></td>
			</tr>
			<tr>
				<th>P W</th>
				<td><input type ="password" name= "mypw"/></td>
			</tr>
			<tr>
				<td colspan ="2" align ="right">
					<input type = "button" value="회원 가입" onclick ="location.href='logincontroller.jsp?command=registform'"/>
					<input type ="submit" value = "로그인"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>