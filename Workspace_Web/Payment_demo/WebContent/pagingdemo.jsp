<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

</style>
<body>

	<%@ include file="./form/pstm_header.jsp"%>

	<%
		//이미지, 이름, 위치, 한마디 각오 

	String strPg = request.getParameter("pg");

	String[][] list = { { "img1", "name", "age", "where" }, { "img2", "배유진", "헬창", "어디삼" }, { "img3", "그러니", "어디가", "집에가" },
			{ "img4", "왜그러니", "siasa", "hoh,o" }, { "img5", "왜그러니", "siasa", "hoh,o" },
			{ "img6", "왜그러니", "siasa", "hoh,o" }, { "img7", "왜그러니", "siasa", "hoh,o" },
			{ "img8", "왜그러니", "siasa", "hoh,o" } };
	//우리는 3개씩 출력할거다
	int rowSize = 3;
	//처음에는 1페이지로 갈 거다
	int pg = 1;

	if (strPg != null) {

		pg = Integer.parseInt(strPg);

	}
	//1p 1 * 3 - (3 - 1) = 1
	//2p 2 * 3 - (3 - 1) = 4
	//3p 3 * 3 - (3 - 1) = 7
	
	//시작 페이지
	int from = (pg * rowSize) - (rowSize - 1);
	//마지막 페이지
	//우리 9페이지 있다 == list.length
	int to = (pg * rowSize);
	
	if(to > list.length ){
		
		to = list.length;
		
	}

	int total = list.length; //int total = dao.getTotal() <- list의 총 게시물 수를 불러오는 것을 처리해줘애한다
	int allPage = (int) Math.ceil(total / (double) rowSize);
	int block = 2;

	System.out.println("현재 페이지 수" + strPg);
	System.out.println("전체 페이지 수" + allPage);
	
	//출력되는 페이지 중 첫번째
	int fromPage = ((pg - 1) / block * block) + 1;
	
	//출력되는 페이지 중 마지막
	int toPage = ((pg - 1) / block * block) + block;
	if (toPage > allPage) {
		toPage = allPage;
	}

	System.out.println("페이지 시작" + fromPage + "페이지 끝" + toPage);
	%>

	<table>
		<tr>
			<th>이미지</th>
			<th>이름</th>
			<th>경력</th>
			<th>한마디</th>
		</tr>

		<%
			for (int i =from-1 ; i <to ; i++) {
			//BoardDto b = list.get(i);
			//뒤에 것들도 dto로 바꾼다면 다 바꿔줘야함 하지만 지금은 리스트라굽굽
		%>
			
			<tr>
				<td><%=list[i][0] %></td>
				<td><%=list[i][1] %></td>
				<td><%=list[i][2] %></td>
				<td><%=list[i][3] %></td>
			</tr>
		<%
			}
		%>
		
	</table>
	
	<table>
		<tr>
			<td align = "center">
			<%
				//처음, 이전 링크 넘길 수 없을 땐 이전으로 갈 수 없도록 처리해둔다
				if(pg > block){
					
			%>
				<a href = "pay.do?command=subscription&pg=1">◀◀</a>
				<a href=  "pay.do?command=subscription&pg=<%=fromPage-1%>"></a>
				
			<%}else{ %>
				
				<span style = "color:gray">◀◀</span>
				<span style = "color:gray">◀</span>
				
				
			<%} %>
			
			<%
				for(int i=fromPage; i <=toPage; i++){ 
					
					if(i==pg){ %>
					
					<%=i%>
					
					<%}else{ %>
					
						<a href = "pay.do?command=subscription&pg=<%=i%>"><%=i %></a>
					
					<%}
					}%>
			
			<%
				if(toPage<allPage){
			%>
			
				<a href = "pay.do?command=subscription&pg=<%=toPage + 1%>">▶</a>
				<a href ="pay.do?command=subscription&pg=<%=allPage %>">▶▶</a>
			
			
			<%}else{ %>
				
				<span style = "color:gray">▶</span>
				<span style = "color:gray">▶▶</span>
			
			<%} %>

			</td>
		</tr>
	
	</table>

	<%@ include file="./form/pstm_footer.jsp"%>

</body>
</html>