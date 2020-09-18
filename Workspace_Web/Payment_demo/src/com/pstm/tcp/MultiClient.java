package com.pstm.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiClient {
	
	Socket socket = null;
	String ipNumber = "";
	int portNumber = 9999;
	
	public void makeClient() {
	
		
		System.out.println("DEBUG1 : client 생성");
		/*
		  try {
			   
			   //////////////////////////////////////////////////////////
			   // 1. IP 주소 입력 사항 확인
			   //////////////////////////////////////////////////////////
			   if(args.length != 2) {
			    System.out.println("Server IP, Port 입력 바랍니다.");
			    System.exit(0);
			   }else {
			    ipNumber = args[0];
			    portNumber = Integer.parseInt(args[1]);
			   }
			   //////////////////////////////////////////////////////////
			   

			   ////////////////////////////////////////////
			   // 2. Server 에서 열어놓은 Port 로 접속
			   ////////////////////////////////////////////
			   socket = new Socket(ipNumber, portNumber);
			   ////////////////////////////////////////////
			*/   
		
		try {
			//server에서 열어놓은 port로 접속
			
			System.out.println("DEBUG2 : 포트 접속 ");
			socket = new Socket(ipNumber, portNumber);
			
			//Thread를 가진 multiClientThread 객체 생성
			MultiClientThread clientThread = new MultiClientThread(socket);
			System.out.println("DEBUG3 : 객체 생성");
			
			//clientThread.login();
			
			//채팅 시작(메시지 보기)
			clientThread.start();
			
			System.out.println("DEBUG4 : 채팅 시작(메시지 보기)");
			
			//채팅 시작(메시지 입력)
			clientThread.chatProcess();
			System.out.println("DEBUG5 : 채팅 시작(메시지 입력) ");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
