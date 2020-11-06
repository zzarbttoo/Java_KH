package com.pstm.socket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket {
	
	//@OnOpen, @OnMessage, @OnClose, @OnError 4개의 어노테이션으로 브라우저와의 통신 관리를 한다
	
	//콘솔 접속 로그 표시
	@OnOpen
	public void handleOpen() {
		
		System.out.println("client is now connected");	
		
	}
	
	//websocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public String handleMessage(String message) {
		
		System.out.println("receive from client:" + message);
		String replymessage = "echo" + message;
		System.out.println("send to client : " + replymessage);
		
		return replymessage;
	}
	
	//콘솔에 접속 끊김 로그를 출력한다
	@OnClose
	public void handleClose() {
		
		System.out.println("client is now disconnected");
		
	}
	
	//websocket과 브라우저 간 통신 문제가 발생하면 요청되는 함수
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
	
}
