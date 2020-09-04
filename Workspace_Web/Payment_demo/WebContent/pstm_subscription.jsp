<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file = "./form/pstm_header.jsp" %>

<%
	//이미지, 이름, 위치, 한마디 각오 
	String[][] list ={{"img0","name", "age","where"}, {"img1", "배유진", "헬창", "어디삼"}, {"img2", "그러니", "어디가", "집에가"}, {"img3", "왜그러니", "siasa", "hoh,o"}};
%>
	<div id = "pstm_subscription_wrapper">
		<div class="pstm_subscription_title"></div>
		<div class="pstm_subscription_list"></div>
	
	</div>
	

</body>
</html>