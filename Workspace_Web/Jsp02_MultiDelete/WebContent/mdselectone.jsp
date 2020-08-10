<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import = "com.muldel.dto.MDBoardDto"
	import = "com.muldel.biz.MDBoardBiz"
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
	int myseq = Integer.parseInt(request.getParameter("myseq"));
	MDBoardBiz biz = new MDBoardBiz();
	
	MDBoardDto dto = biz.selectOne(myseq);
	
%>
	
	
	<table border = "1">
	
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>	
			<th>내용</th>
			<td><textarea rows = "10" cols = "60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>	
			<td colspan = "3">
				<input type = "button" value = "수정" onclick = "location.href='mdupdate.jsp?mdseq=<%=myseq%>'"/>
				<input type = "button" value = "삭제" onclick = ""/>
				<input type = "button" value = "돌아가기"/>
			</td>
		</tr>
	
	</table>
	
			
		
		
	
	
	



</body>
</html>