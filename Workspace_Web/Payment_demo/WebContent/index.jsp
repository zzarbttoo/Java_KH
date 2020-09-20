<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
</head>
<body>
 <form>
 	<input id = "textMessage" type = "text">
 	<input onclick = "sendMessage()" value = "Send" type = "button">
 	<input onclick = "disconnect()" value = "Disconnect" type = "button">
 </form>
 <br/>
 
 	<!-- 수신 메시지/로그를 표시함 -->
 <textarea id = "messageTextArea" rows = "10" cols = "50"></textarea>
 <script type = "text/javascript">
 
 	//프로젝트명/호스트명
 	var webSocket = new WebSocket("ws://localhost:8787/Payment_demo/websocket");
 	var messageTextArea = document.getElementById("messageTextArea");
 	
 	webSocket.ononopen = function(message){
 		
 		messageTextArea.value += "Server conntect...\n";
 		
 	};
 	
 	
 	webSocket.onclose = function(message){
 		
 		messageTextArea.value += "Server Disconnect...\n";
 	};
 	
 	webSocket.onerror = function(message){
 		
 		messageTextArea.value += "error ... \n";
 		
 	};
 	
 	webSocket.onmessage = function(message){
 		
 		messageTextArea.value += "Recieve From Server" + message.data + "\n";
 		
 	}
 	
 
 	function sendMessage(){
 		
 		var message = document.getElementById("textMessage");
 		messageTextArea.value += "Send to Server ->"+ message.value + "\n";
 		webSocket.send(message.value);
 		message.value = "";
 	}
 	
 	function disconnect(){
 		
 		webSocket.close();
 		
 	}
 	
 </script>
</body>
</html>