<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="com.mvc.dto.MVCBoardDto"%>
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
		//리퀘스트 객체에 무엇이 담길 지 모르기 때문에 최상위 타입이 오브젝트 타입으로 했다
	//그래서 명시적 형변환을 통해 큰 것을 작은 것으로 넣었다
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("list");
	%>

	<h1>LIST</h1>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<%
			if (list.size() == 0) {
		%>
		<tr>
			<td colspan="4">-----------------작성된 글이 존재하지 않습니다--------------</td>
		</tr>
		<%
			} else {
				
				for(MVCBoardDto dto : list){
		%>
				<tr>
					<td><%=dto.getSeq() %></td>
					<td><%=dto.getWriter() %></td>
					<td><a href="mvccontroller.jsp?command=detail&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
					<td><%=dto.getRegdate() %></td>
				</tr>
		
				<%} %>
		<%
			}
		%>
		
		<tr>
			<td colspan = "4" align = "right">
				<input type = "button" value = "글작성" onclick = "location.href='mvccontroller.jsp?command=insertform'"/>
			</td>
		</tr>
	</table>

</body>
</html>