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

<script type="text/javascript">
	function idChkConfirm() {

		var chk = document.getElementsByName("id")[0].title;
		if (chk == "n") {

			alert("아이디 중복체크를 먼저 해주세요");
			document.getElementsByName("id")[0].focus();
		}

	}
	//id 중복체크
	function idChk() {

		var doc = document.getElementsByName("id")[0];
		alert(doc.value);
		if (doc.value == null || doc.value.trim() == "") {
			alert("아이디를 먼저 입력해 주세요");

		} else {
			//""는 이 팝업창이 열릴 프레임 이름
			open("logincontroller.jsp?command=idchk&id="+doc.value,"",
					"width=200, height = 200");

		}
	}

	//id 중복체크 완료했는지 여부
</script>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="registformres" />
		<table border="1">
			<col width="100">
			<col width="100">
			<col width="100">
			<col width="100">
			<col width="100">
			<col width="100">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>

			<tr>
				<td><input type="text" name="id" required="required" title="n" />
					<input type="button" value="중복체크" onclick="idChk();" /></td>
				<td><input type="password" name="password"
					onclick="idChkConfirm();" required="required" /></td>
				<td><input type="text" name="name" onclick="idChkConfirm();"
					required="required" /></td>
				<td><input type="text" name="address" onclick="idChkConfirm();"
					required="required" /></td>
				<td><input type="text" name="phone" onclick="idChkConfirm();"
					required="required" /></td>
				<td><input type="text" name="email" onclick="idChkConfirm();"
					required="required" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="가입" />
				</td>
			</tr>
		</table>



	</form>


</body>
</html>