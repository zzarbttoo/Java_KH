package com.pstm.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	Socket socket = null;
	ServerSocket serverSocket = null;

	MultiChatRoom multiChatroom = null;
	MultiServerThread tempServerThread = null;

	int portNumber = 9999;

	public void makeServer() {
		// multiChatroom 생성
		multiChatroom = new MultiChatRoom();
		System.out.println("DEBUG1 : 채팅방 생성");
		// portNumber 기반 소켓 생성
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("DEBUG2 : 소켓 생성");
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
		}

		// 채팅 중지 가능하도록 해줘야하나
		while (true) {

			try {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress());

				System.out.println("DEBUG3 : 리스트에 저장");
				// 접속된 client를 ArrayList에 저장
				tempServerThread = new MultiServerThread(socket, multiChatroom);
				System.out.println("DEBUG4 : 스레드 할당");
				// 원래는 여기에 로그인 처리도 들어가야하나봄
				tempServerThread.start();

				System.out.println("DEBUG5 : 스레드 시작");
				// 채팅 객체를 ArrayList에 저장
				multiChatroom.enterRoom(tempServerThread);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
