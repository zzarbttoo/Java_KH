package com.pstm.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		
		
		try {
			 
			//ServerSocket 클래스로 객체를 만듦 <- 이 때 포트를 하당하게 되며, 우리는 8888로 설정했다
			ServerSocket s_socket = new ServerSocket(8888);
			
			System.out.println("난 서버");
			
			//accept는 클라이언트가 들어오는 것을 대기하는 역할을 한다 
			//accept로 받은 c_socket이 클라이언트와 1:1 연결(할당)된 소켓이다 -> c_socket으로 통신이 가능하다
			Socket c_socket= s_socket.accept();
			
			//서버에 전달할 메세지를  작성한다
			OutputStream output_data = c_socket.getOutputStream();
			String sendDataString = "Welcome to My Server";
			
			//outputsetream 객체에 전달할 메시지를 전달한다
			output_data.write(sendDataString.getBytes());
			
			
			s_socket.close();
			c_socket.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
