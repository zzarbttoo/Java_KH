<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.muldel.biz.MDBoardBiz"
	import="com.muldel.dto.MDBoardDto"%>
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
	<%
		int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	MDBoardDto dto = new MDBoardDto(seq, title, content);
	MDBoardBiz biz = new MDBoardBiz();

	int res = biz.update(dto);
	if (res > 0) {
	%>

	<script type="text/javascript">
		
	alert("수정 성공");
	location.href ="mdselectone.jsp?myseq=<%=seq%>";
	</script>


	<%
		} else {
	%>

	<script type="text/javascript">
	alert("실패");
	location.href="mdselectone.jsp?myseq=<%=seq%>";
	</script>
	<%
		}
	%>

</body>
</html>