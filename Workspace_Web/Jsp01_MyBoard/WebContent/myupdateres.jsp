<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import = "com.my.dao.MyBoardDao"
	import = "com.my.dto.MyBoardDto"
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
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardDto dto = new MyBoardDto();
	MyBoardDao dao = new MyBoardDao();
	
	dto.setMyno(myno);
	dto.setMyname(myname);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	int res=dao.update(dto);
	
	if(res > 0){
%>
	
	<script type = "text/javascript">
	
		alert("성공");
		location.href = "mylist.jsp";
	
	</script>
	

<%
	}else{
%>
	
	<script type = "text/javascript">
		alert("실패");
		location.href="myupdate.jsp";
	</script>
<%	} %>




</body>
</html>