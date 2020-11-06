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

	<table>
		<tr>
			<th>이름</th>
			<td><%=dto.getMyid()%></td>

		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=dto.getMypw()%></td>

		</tr>
		<tr>
			<th>이름</th>
			<td><%=dto.getMyname()%></td>

		</tr>
		<tr>
			<th>주소</th>
			<td><%=dto.getMyaddr()%></td>

		</tr>
		<tr>
			<th>번호</th>
			<td><%=dto.getMyphone()%></td>

		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getMyemail()%></td>
		</tr>
		<tr>
			<td colspan = "2" align = right>
				<input type = "button" value = "정보 수정" onclick = "location.href='logincontroller.jsp?command=update&myno=<%=dto.getMyno()%>'"/>
				<input type = "button" value = "회원 탈퇴" onclick = "location.href='logincontroller.jsp?command=withdraw&myno=<%=dto.getMyno()%>'"/>
			</td>
		</tr>
	</table>






</body>
</html>