<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f40be23a0183befcdd925726da9fa7d7"></script>
<body>
	<!-- 지도 객체 생성 -->
	<div id="map" style="width: 100%; height: 350px;"></div>

	<!-- 지도에 점 표시 -->
	<script>
		$(function() {

			$.getJSON("http://localhost:5000/jsonparse", function(data) {

				mapwhere(data)

			})

		});

		function mapwhere(data) {

			console.log(data)

			var mapContainer = document.getElementById('map') // 지도를 표시할 div 
			, mapOption = {
				center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				level : 13
			// 지도의 확대 레벨
			};

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니
			// 지도에 표시할 원을 생성합니다

			var circle = new kakao.maps.Circle({
				center : new kakao.maps.LatLng(36.7670716, 128.0742461), // 원의 중심좌표 입니다 
				radius : 50, // 미터 단위의 원의 반지름입니다 
				strokeWeight : 5, // 선의 두께입니다 
				strokeColor : '#FF0000', // 선의 색깔입니다
				strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				strokeStyle : 'solid', // 선의 스타일 입니다
				fillColor : '#FF0000', // 채우기 색깔입니다
				fillOpacity : 0.7
			// 채우기 불투명도 입니다   
			});

			// 지도에 원을 표시합니다 
			circle.setMap(map);
		}
	</script>
</body>
</html>