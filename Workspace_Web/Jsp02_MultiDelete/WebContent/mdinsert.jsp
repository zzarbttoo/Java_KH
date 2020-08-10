<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="mdinsertres.jsp" method="post">

		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="mdWriter" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mdTitle" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mdcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="취소" onclick="" />
					<input type="submit" value="작성" /></td>
			</tr>
		</table>

	</form>



</body>
</html>