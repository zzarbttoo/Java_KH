package com.test02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		
		//클라이언트 생성
		//포트 번호를 주면 서버 생성, 아니면 자가기 소켓이 된다
		DatagramSocket ds = new DatagramSocket(); 
		System.out.println("클라이언트 입니다.");
		
		//보낼 데이터 생성
		byte[] buff = "연습입니다.".getBytes();
		
		//패킷으로 감싼다(보낼 데이터, 데이터 크기, 목적지 주소, 포트 번호)
		DatagramPacket sendP = new DatagramPacket(buff, buff.length,InetAddress.getByName("localhost"),8888);
		
		//보낸다
		ds.send(sendP);
		
		ds.close();
		ds.disconnect();
	}

}
