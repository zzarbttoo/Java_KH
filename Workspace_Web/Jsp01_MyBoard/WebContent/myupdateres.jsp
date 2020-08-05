<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@
page
	import = "com.my.dao.MyBoardDao"
	import ="com.my.dto.MyBoardDto"

 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	int myno = Integer.parseInt(request.getParameter("myno"));
	String mytitle=  request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardDto dto = new MyBoardDto();
	dto.setMyno(myno);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	MyBoardDao dao = new MyBoardDao();
	int res = dao.update(dto);
	
	if(res > 0){
		
		


%>
	<script type = "text/javascript">
		
		alert("수정 성공");
		location.href = "myselect.jsp?myno=<%=myno%>";
		
	</script>


<%
	}else{
%>
	
	<script type = "text/javascript">
		
		alert("수정실패");
		location.href="myupdate.jsp?myno=<%=myno%>";
	
	</script>


<%
	}
%>


</body>
</html>