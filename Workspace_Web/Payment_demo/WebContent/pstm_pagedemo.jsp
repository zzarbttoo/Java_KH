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
		
		alert(pages);
		url += "?" + "pages =" + pages + "&lines=" + lines;
		System.out.println(url);
		location.href = url;
	}
</script>
<% 
	
	PagingTest paging= (PagingTest) request.getAttribute("paging");
	ArrayList<PagingTestDto > testlist = (ArrayList<PagingTestDto>) request.getAttribute("pagingtestlist");

%>
<body>

	<% if(paging.getCurrentPageNo() != paging.getFirstPageNo()) {%>
	
		<a href= "PagingTServlet?pages=paging.getPrevPageNo()&lines=3">이전페이지</a>
	
	<%} %>
	
	<% for(int i = paging.getStartPageNo(); i <= paging.getEndPageNo(); i++) { %>
	
		<% if( i == paging.getCurrentPageNo()){ %>
		<b><a href = "PagingTServlet?pages=<%=i%>&lines=3"><%=i%></a></b>
		<%}else{ %>
		<a href = "PagingTServlet?pages=<%=i%>&lines=3"><%=i%></a>	
		<% }%>	
	
	
	<%} %>
	



</body>
</html>