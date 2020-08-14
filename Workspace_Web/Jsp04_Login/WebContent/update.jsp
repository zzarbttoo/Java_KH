<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.login.dto.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MYDto dto = (MYDto) request.getAttribute("dto");
%>
<body>
	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="updateres" /> 
		<input type="hidden" name="myno" value="<%=dto.getMyno()%>" />
		<table>

			<tr>
				<th>id</th>
				<td><input type="text" value="<%=dto.getMyid()%>" name="id" /></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type="text" value="<%=dto.getMypw()%>"
					name="password" /></td>
			</tr>

			<tr>
				<th>이름</th>
				<td><input type="text" value="<%=dto.getMyname()%>" name="name" /></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" value="<%=dto.getMyaddr()%>"
					name="address" /></td>

			</tr>

			<tr>
				<th>번호</th>
				<td><input type="text" value="<%=dto.getMyphone()%>"
					name="phone" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" value="<%=dto.getMyemail()%>"
					name="email" /></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="button" value="취소"
					onclick="" /> <input type="submit" value="변경 " /></td>
			</tr>
		</table>

	</form>



</body>
</html>