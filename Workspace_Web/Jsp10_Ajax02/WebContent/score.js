

function getParameterValues(){
	
	var name = "?name=" + encodeURIComponent(document.getElementById("name").value);
	var kor = "&kor=" + document.getElementById("kor").value;
	var eng = "&eng=" + document.getElementById("eng").value;
	var math = "&math=" + document.getElementById("math").value;
	
	return name + kor + eng + math;
	
}

function load(){
	
	var url = "cal.do" + getParameterValues();
	console.log(url);
	
	httpRequest = new XMLHttpRequest();		// 서버와 통신하는 객체
	httpRequest.onreadystatechange = callback; //처리할 함수(레드스테이트가 체인지되는 이벤트가 발생됐을 때 콜백 함수를 호출해라 : 콜백함수 -> 콜하면 처리해주고 백 할 것이다)
	httpRequest.open("GET" , url , true); // true : 비동기 / false : 동기
	httpRequest.send(); //get->send() / post -> send(String) [서버 전송]
	
}

function callback(){
	
	alert("readyState : " + httpRequest.readyState);
	
	if(httpRequest.readyState==4){
		
		alert("status : " + httpRequest.status);
		
		if(httpRequest.status == 200){
			//httpRequest.responseText : 서버에서 리턴받은 string
			// JSON.parse : json 형태의 string -> json object 로 변환 
			// JSON.stringify : json object-> json 형태의 string으로 바꿔준다
			var obj = JSON.parse(httpRequest.responseText); 
			
			document.getElementById("result").innerHTML = decodeURIComponent(obj.name) +
			"님의 총점은" + obj.sum +"이고 평균은 " + obj.avg + "입니다";
			
		}else{
			
			alert("데이터를 계산할 수 없습니다...");
			
		}
		
	}
}

/*
	XMLHttpRequest : javascript object. http을 통한 데이터 송수신을 지원
	
	<onreadyStatechange>
	-readyState
	0 (uninitialized) : 실행(load)되지 않음
	1 (loading) : 로드 중
	2 (loaded) : 로드 됨
	3 (interactive) : 통신 됨
	4 (complete) : 통신 완료
	
	
	-status
	200 : 성공
	400 : bad request
	401 : unauthorized
	403 : forbidden
	404 : not found 
	500 : internal server error
	


*/