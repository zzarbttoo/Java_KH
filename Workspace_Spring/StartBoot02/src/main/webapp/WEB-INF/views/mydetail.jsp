<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
			<tr>
				<th>이름</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.mytitle }</td>
			</tr>

			<tr>
				<th>글내용</th>
				<td><textarea rows="10" cols="60" readonly = "readonly" >${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td>
					<input type = "button" value = "수정" onclick ="location.href='updateform?myno=${dto.myno}'"/>
					<input type = "button" value = "삭제" onclick ="location.href='delete?myno=${dto.myno}'"/>
					<input type = "button" value = "목록" onclick =""/>
				</td>
			</tr>
		</table>

</body>
</html>