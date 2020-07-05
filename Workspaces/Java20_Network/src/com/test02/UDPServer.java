package com.test02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		
		//서버 생성 
		DatagramSocket ds = new DatagramSocket(8888);
		
		System.out.println("서버입니다.");
		
		//데이터 받을 방 생성
		byte[] buff = new byte[1024];
		
		//데이터 받을 패킷
		DatagramPacket recieveP = new DatagramPacket(buff, buff.length);
		
		//받는다
		ds.receive(recieveP);
	
		//받은 데이터 출력
		System.out.println(new String(recieveP.getData()));
		
		ds.close();
		ds.disconnect();
	}
}
