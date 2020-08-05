<%@ page 
	import="com.my.dao.MyBoardDao"
	import = "com.my.dto.MyBoardDto"
	
 %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//키 값을 request.getParameter로 받아주면 된다
int myno = Integer.parseInt(request.getParameter("myno"));
MyBoardDao dao = new MyBoardDao();
MyBoardDto dto = dao.selectOne(myno);

%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset = UTF-8");
	
%>
<body>

	<h1>Select</h1>

	<table>
		<tr>
			<th>이름</th>
			<td><%=dto.getMyname()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getMytitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea rows = "10" cols = "60" readonly = "readonly"><%=dto.getMycontent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "2" align = "right">
				<input type = "button" onclick = "location.href ='myupdate.jsp?myno=<%=dto.getMyno() %>'" value ="수정"/>
				<input type = "button" onclick = "location.href ='mydelete.jsp?myno=<%=dto.getMyno() %>'" value ="삭제"/>
				<input type = "button" onclick = "location.href ='mylist.jsp'" value ="목록"/>
			</td>
		</tr>
	</table>


</body>
</html>