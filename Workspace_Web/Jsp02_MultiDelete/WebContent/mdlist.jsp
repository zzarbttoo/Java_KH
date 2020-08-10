<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ 
	page 
	import="com.muldel.biz.MDBoardBiz" 
	import="java.util.List"
	import="com.muldel.dto.MDBoardDto"	
%>

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

<script type ="text/javascript" src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type = "text/javascript">

	
	function allChk(bool){
		
		/*
		var checkbox = document.getElementsByName("chk");
		console.log(checkbox);
		for(var i = 0; i < checkbox.length ; i++){
			
			checkbox[i].checked = bool;
		}
		
		*/
		$("input[name=chk]").each(function(){
			
			$(this).prop("checked", bool);
		});
		
	}
	
	
	//유효성 검사
	$(function(){
		
			$("#muldelform").submit(function(){
			
			
			//아무것도 체크돼있지 않은 상태이다
			if($("#muldelform input:checked").length == 0){
				
				alert("하나 이상 체크해 주세요");
				//event 전파를 막아준다
				//이벤트가 넘어가는 것과, 그 기능을 막아주는 것 두개가 있는데
				//둘다 막아준다
				return false;
				
			}
			
		});
		
		$("input[name = chk]").click(function(){
			
			if($("input[name = chk]").length == $("input[name=chk]:checked").length){
				
				$("input[name = all]").prop("checked", true);
				
			}else{
				
				$("input[name=all]").prop("checked", false);
				
			}
		});
		
	});
	
		
	function writeForm(){
		
		location.href = "mdinsert.jsp";
	}
	 

</script>

<%
	MDBoardBiz biz = new MDBoardBiz();
List<MDBoardDto> list = biz.selectList();
%>

<body>

	<%@ include file="./form/header.jsp"%>
	<h1>글 목록</h1>
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30px" />
			<col width="50px" />
			<col width="100px" />
			<col width="300px" />
			<col width="100px" />

			<tr>
				<th><input type="checkbox" name="all"
					onclick="allChk(this.checked);" /></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<%
				if (list.size() == 0) {
			%>
			<tr>
				<td colspan="5">-------작성된 글이 존재하지 않습니다------</td>
			</tr>


			<%
				} else {
					//향상된 for문을 사용하는 것이 이득이다
					for(MDBoardDto dto : list){
			%>
					<tr>
						<td><input type ="checkbox" name ="chk" value = "<%=dto.getSeq()%>"></td>
						<td><%=dto.getSeq() %></td>
						<td><%=dto.getWriter() %></td>
						<td><a href = "mdselectone.jsp?myseq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
						<td><%=dto.getRegdate() %></td>
					</tr>


			<%		}
				}
			%>
			
			<tr>	
				<td colspan = "5" align = "right">
					<input type = "button" value  ="글작성" onclick ="writeForm();"/>
					<input type = "submit" value ="선택삭제"/>
				</td>
			</tr>
			
		</table>
	</form>

	<%@ include file="./form/footer.jsp"%>


</body>
</html>