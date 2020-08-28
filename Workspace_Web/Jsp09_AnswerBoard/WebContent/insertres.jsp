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


	<form action = "answer.do" method = "post">
		<input type = "hidden" value = "insertres" name = "command"/>
		<table>
		
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "title"/></td>
			</tr>
			
			<tr>
				<th>글쓴이</th>
				<td><input type = "text" name = "writer"/></td>
			</tr>
	
			<tr>
				<th>내용</th>
				<td><input type = "text" name = "content"/></td>
			</tr>
			
			<tr>	
				<td>
					<button type = "submit">제출하기</button>
				</td>
			</tr>
		</table>
		
	
	
	
	</form>



</body>
</html>