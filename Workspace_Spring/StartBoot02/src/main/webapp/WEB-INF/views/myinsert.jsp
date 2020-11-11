<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="insertres" method="post">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type = "text" name = "myname"/></td>
				
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "mytitle"/></td>
			</tr>

			<tr>
				<th>글내용</th>
				<td><textarea rows="10" cols="60" name ="mycontent"></textarea></td>
			</tr>

			<tr>
				<td>
					<input type = "submit" value = "글작성"/>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>