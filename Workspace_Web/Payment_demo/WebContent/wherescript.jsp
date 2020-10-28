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
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f40be23a0183befcdd925726da9fa7d7&libraries=services,clusterer,drawing"></script>
<body>
	<!-- 지도 객체 생성 -->
	<div id="map" style="width: 750px; height: 850px;"></div>

	<!-- 지도에 점 표시 -->
	<script>
		$(function() {

			$.getJSON("http://localhost:5000/jsonparse", function(data) {

				mapwhere(data)

			})

		});

		function mapwhere(data) {

			//console.log(data)
			
			var keys = Object.keys(data);
			//console.log(keys);

			var mapContainer = document.getElementById('map') // 지도를 표시할 div 
			, mapOption = {
				center : new kakao.maps.LatLng(36.7670716, 128.0742461), // 지도의 중심좌표
				level : 12
			// 지도의 확대 레벨
			};
			
			var markers = [];
			

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			for(var i = 0; i< keys.length; i++){
				
				//undefine에 대한 예외 처리
				if(data[keys[i]][1] != null){
				
				
				console.log(data[keys[i]][1][0]);
				console.log(typeof(data[keys[i]][1][0]));
				console.log(data[keys[i]][1][1]);
				console.log(data[keys[i]][0]*100);
				
				var circle = new kakao.maps.Circle({
					center : new kakao.maps.LatLng(data[keys[i]][1][0], data[keys[i]][1][1]), // 원의 중심좌표 입니다 
					radius : data[keys[i]][0] * 100, // 미터 단위의 원의 반지름입니다 
					strokeWeight : 5, // 선의 두께입니다 
					strokeColor : '#FF0000', // 선의 색깔입니다
					strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
					strokeStyle : 'solid', // 선의 스타일 입니다
					fillColor : '#FF0000', // 채우기 색깔입니다
					fillOpacity : 0.5
				// 채우기 불투명도 입니다   
				
				});
				
			
				
				
				markers.push(circle);
				
				}
						
				circle.setMap(map);
			}
	
				

			// 지도에 원을 표시합니다 
		}
	</script>
</body>
</html>