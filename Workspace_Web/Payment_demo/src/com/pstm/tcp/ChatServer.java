
package com.pstm.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	//포트 번호 임의로 설정했음(수정 가능)
	public static final int PORT = 9999;
	
	public ChatServer() {
		ServerSocket serverSocket = null;
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>();
		
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(소켓에 포트 번호 부여)
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT) );
			consoleLog("연결 기다림 - " + hostAddress + ":" + PORT);
			
			// 3. 요청 대기
			while(true) {
				//클라이언트의 요청이 들어오면 받는다
				System.out.println("DEBUG");
				System.out.println(System.currentTimeMillis());
				Socket socket = serverSocket.accept();
				//스레드 생성 후 run
				new ChatServerProcessThread(socket, listWriters).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if( serverSocket != null && !serverSocket.isClosed() ) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void consoleLog(String log) {
		System.out.println("[server " + Thread.currentThread().getId() + "] " + log);
	}
}
