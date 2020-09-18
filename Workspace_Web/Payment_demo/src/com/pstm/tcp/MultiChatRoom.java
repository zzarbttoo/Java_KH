package com.pstm.tcp;

import java.util.ArrayList;
import java.util.List;

public class MultiChatRoom {

	List<MultiServerThread> serverList = new ArrayList<MultiServerThread>();
	
	//접속자수, 접속자 명을 보여준다
	public void display() {
		
		//현재 접속자 수 
		System.out.println("접속자 수 - >" + serverList.size());
		
		//현재 접속된 client id/ 없으면 보여주지 않는다
		System.out.println("=====접속한 client id=====");
		
		for(int i = 0; i < serverList.size(); i++) {
			
			//id 처리 해주기
			System.out.println(serverList.get(i).strId);
		}
		
	}
	
	//client를 arraylist에 추가
	public void enterRoom(MultiServerThread serverThread) {
		
		serverList.add(serverThread);
		
	}
	
	//client에게 메시지 전송
	public void broadCasting(String message) {
		
		MultiServerThread multiServerThread = null;
		
		for(int i = 0; i< serverList.size(); i++) {
			
			multiServerThread = serverList.get(i);
			multiServerThread.sendMessage(message);
			
		}
		
	}
	
	public void exitRoom(MultiServerThread serverThread) {
		
		boolean isDelete = serverList.remove(serverThread);
		
		if(isDelete) {
			System.out.println("serverThread"+ serverThread.strId + "를 제거");
		}else {
			System.out.println("serverThread 제거 실패");
		}
		
	}
	
	
	
}
