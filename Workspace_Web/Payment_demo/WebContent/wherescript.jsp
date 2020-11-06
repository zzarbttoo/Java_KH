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

			var first_keys = Object.keys(data);
			//console.log(keys);

			var mapContainer = document.getElementById('map') // 지도를 표시할 div 
			, mapOption = {
				center : new kakao.maps.LatLng(36.7670716, 128.0742461), // 지도의 중심좌표
				level : 12
			// 지도의 확대 레벨
			};

			var markers = [];

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

			var place_key = Object.keys(data[first_keys[0]]);
			var cluster_key = Object.keys(data[first_keys[1]]);
			console.log(place_key);

			console.log(data[first_keys[0]][place_key[0]][1][0]);
			//위치 표시, cluster별 색깔 표시

			//cluster 표시

			for (var i = 0; i < place_key.length; i++) {

				var color = null;
				var cluster_number = data[first_keys[0]][place_key[i]][2];
				console.log(data[first_keys[0]][place_key[i]]);

				if (cluster_number == 0) {

					color = 'green';
					
				} else if (cluster_number == 1) {
					
					color = 'yellow';
					
				} else if (cluster_number == 2) {

					color = 'blue';

				} else if (cluster_number == 3) {

					color = 'pink';
					
				} else {

					color = 'skyblue';

				}

				var circle = new kakao.maps.Circle({
					center : new kakao.maps.LatLng(
							data[first_keys[0]][place_key[i]][1][0],
							data[first_keys[0]][place_key[i]][1][1]), // 원의 중심좌표 입니다 
					radius : data[first_keys[0]][place_key[i]][0] * 100, // 미터 단위의 원의 반지름입니다 
					strokeWeight : 5, // 선의 두께입니다 
					strokeColor : color, // 선의 색깔입니다
					strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
					strokeStyle : 'solid', // 선의 스타일 입니다
					fillColor : color, // 채우기 색깔입니다
					fillOpacity : 0.5
				// 채우기 불투명도 입니다   

				});

				markers.push(circle);
				circle.setMap(map);
			}

			for (var i = 0; i < cluster_key.length; i++) {

				console.log(cluster_key[i]);
				console.log(data[first_keys[1]][cluster_key[i]]);

				
				var circle = new kakao.maps.Circle({
					center : new kakao.maps.LatLng(
							data[first_keys[1]][cluster_key[i]][0],
							data[first_keys[1]][cluster_key[i]][1]
							), // 원의 중심좌표 입니다 
					radius : 2000, // 미터 단위의 원의 반지름입니다 
					strokeWeight : 5, // 선의 두께입니다 
					strokeColor : 'red', // 선의 색깔입니다
					strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
					strokeStyle : 'solid', // 선의 스타일 입니다
					fillColor : 'red', // 채우기 색깔입니다
					fillOpacity :1
				// 채우기 불투명도 입니다   

				});

				markers.push(circle);


				circle.setMap(map);
			}

			// 지도에 원을 표시합니다 
		}
	</script>
</body>
</html>