<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.muldel.dto.MDBoardDto"
	import="com.muldel.biz.MDBoardBiz"%>
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
<style type = "text/css">

	#updateform{
		display : none;
	}

</style>
<script type ="text/javascript" src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type = "text/javascript">

	function updateFormView(){
		
		$("#detailform").hide();
		$("#updateform").show();
		
	}
	
	function detailForm(){
		
		$("#updateform").hide();
		$("#detailform").show();
		
	}

</script>

<body>

	<%
		int myseq = Integer.parseInt(request.getParameter("myseq"));
	MDBoardBiz biz = new MDBoardBiz();

	MDBoardDto dto = biz.selectOne(myseq);
	%>

	<div id= "detailform">
		<h1>Select</h1>
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="3"><input type="button" value="수정"
					onclick="updateFormView();" /> <input type="button" value="삭제"
					onclick="location.href='mddelete.jsp?seq=<%=dto.getSeq() %>'" /> <input type="button" value="돌아가기" /></td>
			</tr>

		</table>
	</div>

	<div id="updateform">
		<h1>UPDATE</h1>
		<form action="mdupdateres.jsp" method="post">
			<input type="hidden" name="seq" value="<%=dto.getSeq()%>" />

			<table border="1">

				<tr>
					<th>작성자</th>
					<td><%=dto.getWriter()%></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value=<%=dto.getTitle()%> /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
				</tr>
				<tr>
					<td>
					<input type ="button" value = "취소" onclick ="detailForm();"/>
					<input type = "submit" value = "수정"/>
					</td>
				</tr>



			</table>
		</form>
	</div>








</body>
</html>