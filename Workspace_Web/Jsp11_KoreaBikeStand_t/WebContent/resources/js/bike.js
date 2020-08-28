$(function(){
	getJsonData();
});

function getJsonData() {
	//.getJSON = ajax
	//GET HTTP request를 이용해 서버로부터 encode 된 json data를 받아온다
	//url, data(서버에 request와 함께 보낼 data)<-근데 이번 getJSON 에서는 생략됨, success(request 성공 시 실행됨)
	$.getJSON("resources/json/bike.json", function(data){
		$.ajax({
			url: "bike.do",
			method: "post",
			//data는 URL에 쿼리스트링으로 연결된다
			//JSON.stringify data :  javascript객체를 를 json string으로 만들었다
			data: {"command": "getdata", "data": JSON.stringify(data)},
			dataType: "json",
			success: function(msg){
				var $tbody = $("tbody");
				var list = msg.result;
				for (var i = 0 ; i < list.length ; i++) {
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					//집에 보내줘
					$tbody.append($tr);
				}
			},
			error: function(){
				alert("통신 실패");
			}
		});
	});
}
