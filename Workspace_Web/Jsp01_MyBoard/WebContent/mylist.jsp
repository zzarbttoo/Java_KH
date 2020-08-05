<%@ page import="com.my.dao.MyBoardDao" import="java.util.List"
	import="com.my.dto.MyBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset = UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//java 영역
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectList();
	%>
	<h1>List</h1>

	<table border="1">
		<col width="50px" />
		<col width="100px" />
		<col width="300px" />
		<col width="100px" />

		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>

		<%
			//리스트를 반복적으로 돌면서 tr을 만들어 줄 것이다
		//<%= 을 넣어서 자바 영역의 값이 <td></td> 사이로 들어가게 된다(html 값으로 바뀜) <-컴파일 시 바뀐다
		for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getMyno()%></td>
			<td><%=list.get(i).getMyname()%></td>
			<td><a href="myselect.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle()%></a></td>
			<td><%=list.get(i).getMydate()%></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" onclick="location.href='myinsert.jsp'" value="글쓰기" />
			</td>
		</tr>
		
		<%
			}
		%>

	</table>




</body>
</html>