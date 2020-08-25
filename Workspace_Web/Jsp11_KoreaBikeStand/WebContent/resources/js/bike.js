
$(function(){
	
	getJsonData();
	
	
});

function getJsonData(){
	
	$.getJSON("resources/json/bike.json", function(data){
		
		console.log(data);
		
		$.ajax({
			
			url : "bike.do",
			method : "post", 
			data : {"command" : "getdata" , "data" : JSON.stringify(data)},
			dataType : "json",
			success : function(msg){
				
				var $tbody = $("tbody");
				var list = msg.result;
				
				for(var i = 0; i < list.length; i++){
					
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					
					$tbody.append($tf);
				}
				
			},
			error : function(){
				
				alert("통신 실패");
			}
		});
	})

	
}