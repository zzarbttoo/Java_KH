<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
	//start loading
	/*
	$(window).load(function() {

		IMP.init("imp43617146");

	});
	
	 */

	//already loading
	$(document).ready(function() {

		IMP.init("imp43617146");
		
	});
	 
	function payment(){

			IMP.request_pay({

				pg : 'kakao',
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : "주문명 : 결제 테스트",
				amount : "14000",
				buyer_email : "qodbwls70@naver.com",
				buyer_name : "배유진",
				buyer_tel : "010-3333-3333",
				buyer_addr : "서울시 역삼역"

			}, function(rsp) {

				if (rsp.success) {
					var msg = "결제가 완료되었습니다";
					msg += "고유 아이디" + rsp.imp_uid;
					msg += "상점 거래 id" + rsp.merchant_uid;
					msg += "결제 금액" + rsp.paid_amount;
					msg += "카드 승인 번호" + rsp.apply_num;
					

				} else {

					var msg = "결제에 실패하였습니다";
					msg += "에러내용" + rsp.error_msg;
				}

				alert(msg);

			});

		}

</script>


</head>
<body>


	<h1>카카오페이 api 이용하기</h1>
	
	
	<input type = "button" onclick = "payment();" value = "결제 버튼"/>
	<div id = "result"></div>
	
	







</body>
</html>