package com.pstm.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {

		try {
			
			//socket 객체를 생성하여 연결을 시도하는 부분(ip주소와 port 번호를 매개변수로 넘겨야 한다)
			Socket c_socket = new Socket("192.168.0.2", 8888);
			
			//
			InputStream input_data = c_socket.getInputStream();
			
			byte[] receiveBuffer =  new byte[100];
			//연결이 되었다면 데이터를 바이트형태로 받아옴
			input_data.read(receiveBuffer);
			
			//콘솔 창에 데이터를 스트링 형태로 받아와서 출력
			System.out.println(new String(receiveBuffer));
			
			c_socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}

}
