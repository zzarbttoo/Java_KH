<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page
	import = "com.mvc.dto.*"

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

	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto"); 
	System.out.println("여기냐");
	System.out.println(dto.getContent());
	System.out.println(dto.getSeq());
	System.out.println(dto.getTitle());
	System.out.println(dto);
	
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
		<tr align = "right">
			<td>
			<input type = "button" value = "취소" onclick =""/>
			<input type = "button" value = "수정" onclick = "location.href='mvccontroller.jsp?command=update&seq=<%=dto.getSeq()%>'"/>
			<input type = "button" value = "삭제" onclick = "location.href='mvccontroller.jsp?command=delete&seq=<%=dto.getSeq()%>'" />
			</td>
			
		</tr>
		
		
		
	
	</table>





</body>
</html>