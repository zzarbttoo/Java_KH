package com.test01;

import java.io.*;
import java.net.Socket;

//스레드화 시켰음
//그렇기 때문에 고객이 여러명이 동시에 같이 실행될 수 있다
public class TCPClient implements Runnable {

	@Override
	public void run() {
		try{
			Socket clientSocket;
			PrintWriter out = null;
			BufferedReader in = null;
			BufferedReader stdin = null;
			
			System.out.println("server에 접속합니다...");
			
			//어떤 소켓으로 , 어떤 포트번호를 가지고 접속할 건지 담고 있다
			//localhost 바꾸면 선생님 컴퓨터 접속도 가능함3ㄷㄷㄷㄷ
			clientSocket = new Socket("localhost",9999);

			// 서버로 보내주는 객체
			out = new PrintWriter(clientSocket.getOutputStream(),true);
			//서버에서 받아오는 객체
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));			
			//여기서 받아오는 값을 입력해줄거야
			stdin = new BufferedReader(new InputStreamReader(System.in));	
			
			String inputLine;
			//한줄씩 읽자
			while((inputLine = stdin.readLine()) != null){
				//보내주자
				out.println(inputLine);
				System.out.println("server로부터 다시 받은 메시지 :" + in.readLine());
			}
			
			out.close();
			in.close();
			stdin.close();
			clientSocket.close();
			
			
		}catch(IOException e){
		}
	}
	
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new TCPClient());
		t1.start();
	}
}
