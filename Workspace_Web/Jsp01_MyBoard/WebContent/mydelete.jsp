<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import = "com.my.dao.MyBoardDao"
 %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyBoardDao dao = new MyBoardDao();
		int res =dao.delete(myno);
		System.out.println(res);
		
		
		
		if(res > 0){
	%>
	
		<script type = "text/javascript">
			alert("성공");
			location.href = "mylist.jsp";
		</script>
	
	
	<% }else{%>
		
		<script type = "text/javascript">
			alert("실패");
			location.href = "myselect.jsp"
		
		</script>


	<% } %>

</body>
</html>