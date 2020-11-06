<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import = "com.my.dao.MyBoardDao"
	import= "com.my.dto.MyBoardDto"
 %>    
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyBoardDao dao = new MyBoardDao();
		MyBoardDto dto = dao.selectOne(myno);
		
	%>
	
	<h1>UPDATE</h1>
	
	<!-- post로 전송할 때는 폼태그! -->
	<form action = "myupdateres.jsp" method= "post">
	
		<input type = "hidden" name = "myno" value = "<%=dto.getMyno()%>"/>
		<table border = "1">
			<tr>
				<!-- 이름도 수정할꺼면 얘도 input tag로 넘겨줘야하지만, 지금은 아니다 그러므로 인풋 태그 아니고 td에 그냥 넣어도 된다 -->
				<th>이름</th>
				<td><input type = "text" name = "myname" value = "<%=dto.getMyname()%>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "mytitle" value = "<%=dto.getMytitle()%>"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea row = "10" cols = "60" name = "mycontent"><%=dto.getMycontent() %></textarea></td>
			</tr>
			<tr>	
				<td>
					<input type ="submit" value ="작성" onclick = "location.href='myupdate.jsp'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>