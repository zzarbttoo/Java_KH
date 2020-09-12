<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import = "com.pstm.dto.*"
	import = "com.pstm.paging.*"
	import = "java.util.ArrayList"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	function goPage(url, pages, lines){
		
		url += "?" + "pages =" + pages + "&lines=" + lines;
		location.href = url;
	}
</script>
<% 
	
	PagingTest paging= (PagingTest) request.getAttribute("paging");
	ArrayList<PagingTestDto > testlist = (ArrayList<PagingTestDto>) request.getAttribute("pagingtestlist");

	System.out.println(testlist);
	
	
%>
<body>

	




</body>
</html>