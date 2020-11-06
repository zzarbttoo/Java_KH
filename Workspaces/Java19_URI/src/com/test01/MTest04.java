package com.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MTest04 {

	
	public static void main(String[] args) throws UnknownHostException {
		
		
		//내 컴퓨터의 ip 주소가 나온다
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr);
		System.out.println("localhost : " + addr.getHostAddress());
		System.out.println("host name : " + addr.getHostName() + "\n");
		
		//naver 의 ip 주소를 얻어왔다
		//DNS가 ip 주소를 www.naver.com과 연결을 해준것이다
		InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
		
		for(int i = 0; i < naver.length; i++) {
			
			System.out.println(naver[i].getHostAddress());
		}
		
		
	}
	
	
}
