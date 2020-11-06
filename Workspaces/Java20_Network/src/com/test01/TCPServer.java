package com.test01;

import java.io.*;
import java.net.*;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null; // 서버 생성
		Socket serviceSocket; 			  // 접속된 클라이언트
		PrintWriter out = null;			  // 출력 객체
		BufferedReader in = null;		  // 클라이언트에서 읽어들인 값을 버퍼에 담아서 사용할 객체
		
		try {
			// 서버를 생성하면서 포트를 지정 
			// ip 가 포트(방문)을 통해 들어올거야
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
		}
		
		while(true){
			System.out.println("client를 기다립니다...");
			try {
				
				//서버 -> 클라이언트 : output
				//클라이언트 -> 서버 : input
				//client가 접속한 정보를 serviceSocket으로 담았음
				
				serviceSocket = serverSocket.accept();
				System.out.println("client가 접속했습니다...");
				
				//클라이언트 -> 서버 를 inputStreamReader로 읽어들이자
				
				//1. client에게 받은 내용을 읽어줄 객체
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));

				//2. 내보내줄 객체를 생성했다
				//autoFlush - A boolean; if true, the println, printf, 
				//or format methods will flush the output buffer
				out = new PrintWriter(serviceSocket.getOutputStream(),true);
				
				//한줄 씩 읽자!
				String inputLine;
				while((inputLine = in.readLine()) != null){
					System.out.println("client가 보낸 메시지 : " + inputLine);
					//보내주자
					out.println(inputLine);
				}
				
				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();
				
				
			} catch (IOException e) {
			}
		}
	}
}
