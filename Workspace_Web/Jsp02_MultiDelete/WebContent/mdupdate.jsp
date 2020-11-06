<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import= "com.muldel.biz.MDBoardBiz"
	import= "com.muldel.dto.MDBoardDto"
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
	int mdseq = Integer.parseInt(request.getParameter("mdseq"));
	MDBoardBiz biz = new MDBoardBiz();
	MDBoardDto dto = biz.selectOne(mdseq);
	
%>

	<form>
		<input type = "text" hidden = "hidden" value = "<%=dto.getSeq()%>"/>
		<table border ="1">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" value ="<%=dto.getTitle()%>"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type ="text" value = "<%=dto.getContent()%>" name = "mdContent"/></td>
			</tr>
			<tr>
				<input type ="button" />
				<input type ="button"/>
				<input type = "button"/>
			</tr>
		</table>
	
	</form>


</body>
</html>