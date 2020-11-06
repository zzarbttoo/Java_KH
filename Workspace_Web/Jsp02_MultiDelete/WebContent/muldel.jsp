<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@
	page
	import = "com.muldel.biz.MDBoardBiz"
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
		String[] seqs = request.getParameterValues("chk");
		if (seqs == null || seqs.length == 0) {
	%>
	<script type="text/javascript">
		alert("하나 이상 체크해주세요!!!");
		location.href = "mdlist.jsp";
	</script>

	<%
		} else {
			
		//체크된 값이 있다는 뜻
		MDBoardBiz biz = new MDBoardBiz();
		int res = biz.multiDelete(seqs);
		if(res == seqs.length){
			
	%>
		<script type = "text/javascript">
		
		 	alert("선택된 글들을 삭제 완료하였습니다");
		 	location.href = "mdlist.jsp";
		
		</script>
	

		<%}else{ %>

		<script type = "text/javascript">
			
			alert("선택된 글들을 삭제 실패했습니다");
			location.href="mdlist.jsp";
		
		</script>

		<%} %>

	<%
		}
	%>
</body>
</html>