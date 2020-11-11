<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- action = "/myboard/updateres" -->
		<form action="./updateres" method = "post">
		<input type = "hidden" value = "${dto.myno }" name = "myno"/>
		<table border="1">
			<tr>
				<th>이름</th>
				<td>${dto.myname }</td>
				
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" value = "${dto.mytitle }" name = "mytitle"/></td>
			</tr>

			<tr>
				<th>글내용</th>
				<td><textarea rows="10" cols="60" name ="mycontent">${dto.mycontent }</textarea></td>
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