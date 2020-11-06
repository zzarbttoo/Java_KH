package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {

	//java.net에 네트워크와 관련된 것들이 들어가있다
	public static void main(String[] args) throws URISyntaxException {
		
		//local host, 127.0.0.1
		
		//이거를 다 자를 수 있다
		//누가 어디서 무엇을 요청하는지를 알 수 있다 
		URI u = new URI("http://localhost:8787/Java19_URI_Web/res.jsp?qname=%EB%B0%B0%EC%9C%A0%EC%A7%84&qaddr=%EA%B0%80%EC%A2%8C%EB%A1%9C+344");
		
		System.out.println(u.getScheme());
		System.out.println(u.getHost());
		System.out.println(u.getPort());
		System.out.println(u.getPath());
		System.out.println(u.getQuery());
		
		
	}
	
	
	
}
