<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page

	import = "com.muldel.dao.MDBoardDao"
	import = "com.muldel.dto.MDBoardDto"
	import = "com.muldel.biz.MDBoardBiz"
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	String mdWriter = request.getParameter("mdWriter");
	String mdTitle = request.getParameter("mdTitle");
	String mdContent = request.getParameter("mdContent");
	
	MDBoardDto dto = new MDBoardDto(mdWriter, mdTitle, mdContent);
	MDBoardBiz biz = new MDBoardBiz();
	
	int res=biz.insert(dto);
	System.out.println(res);
	 
	if(res > 0){
%>

	<script type = "text/javascript">
		
		alert("성공");
		location.href = "mdlist.jsp";
	
	</script>

<% }else{ %>

	<script type = "text/javascript">
	
		alert("실패");
		location.href = "mdinsert.jsp";
		
	</script>

<% } %>
</body>
</html>