<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.List" import="com.login.dto.*"%>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
	
	function updateRole(myno){
		
		location.href="logincontroller.jsp?command=updaterole&myno=" + myno;
		
	}

</script>

</head>
<%
	List<MYDto> list = (List<MYDto>) request.getAttribute("list");
%>
<body>

	<h1>LIST ENABLED</h1>
	
	<table border ="1">
		<col width="50">
		<col width="180">
		<col width="200">
		<col width="350">
		<col width="150">
		<col width="250">
		<col width="100">
		<col width="50">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>등급</th>
			<th>등급 변경</th>
		</tr>
		<%
			for (MYDto dto : list) {
		%>
		<tr>
			<td><%=dto.getMyno()%></td>
			<td><%=dto.getMyid()%></td>
			<td><%=dto.getMyname()%></td>
			<td><%=dto.getMyaddr()%></td>
			<td><%=dto.getMyphone()%></td>
			<td><%=dto.getMyemail()%></td>
			<td><%=dto.getMyrole()%></td>
			<td><input type ="button" value = "변경" onclick ="updateRole(<%=dto.getMyno()%>)"/></td>
			
		</tr>

		<%
			}
		%>
		<tr>
			<td colspan = "8" align = "right">
				<input type ="button" value = "메인" onclick=""/>
			</td>
		</tr>
		
	
	</table>




</body>
</html>