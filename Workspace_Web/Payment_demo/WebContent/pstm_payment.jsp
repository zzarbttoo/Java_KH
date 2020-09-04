<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

.payment_container {
	width : 1100px;
	height : auto;
	padding: 50px 0;
	border: 1px solid #e8e8e8;
	margin: 0 auto;
	background-color : skyblue;
}

.trainerImg {
	display: inline-block;
	overflow: hidden;
	line-height: 1;
	vertical-align: middle;
}

.left_area{
	margin-left:150px;
	overflow : hidden;
	background-color : blue;
}

.section_head >h2{
	
	font-size: 25px;
	margin-bottom : 25px;
}

.right_area{
	 
}

</style>
<body>
	<%@ include file="./form/pstm_header.jsp"%>

	<div class="pstm_payment_wrapper">
		<div class="payment_container section">
			<div class ="trainer_section">
			<div class="left_area">
				<div class="section_head">
					<h2>트레이너 정보</h2>
				</div>

				
				<a href="#"><img src="./resources/img/select/img1.jpg"
					width="260" height="260" style="height: auto;" class="trainerImg" /></a>
			</div>
			<div class ="right_area">
				<p class ="intro_name">"꼬미" 트레이너</p>
				<pre class ="intro_info">트레이너 경력을 쓰자</pre>
				<p class ="intro_answer">"트레이너의 응원 한마디</p>
				<p class ="intro_address">주소:"트레이너의 주소를 쓰자" <img id ="trainer_map" src = "./resources/img/select/pstm_select_map.png"width="20" height="20" style="height: auto;"/></p>
			</div>
			</div>
		</div>

	</div>


</body>
</html>