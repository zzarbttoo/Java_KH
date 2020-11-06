package com.pstm.tcp;

import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	
	//해당 serverip로 바꿔야한다 
	private static final String SERVER_IP = "192.168.144.1";
	private static final int SERVER_PORT = 9999;

	//id값을 받을 수 없다면 로그인을 요청해야한다
	public ChatClientApp(int id){
		
		String name = Integer.toString(id);

		while(true) {
			
			System.out.println("대화명을 입력하세요.");
			//System.out.print(">>> ");
			
			if (id != -1) {
				break;
			}
			//System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		Socket socket = new Socket();
		try {
			
			System.out.println("어디시간임"+System.currentTimeMillis());
			socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
			consoleLog("채팅방에 입장하였습니다.");
			
			//writer 설정, autoflush
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			String request = "join:" + name + "\r\n";
			pw.println(request);
			new ChatWindow(name, socket).show(); //다른 창이 켜지도록 한다 
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void consoleLog(String log) {
		System.out.println(log); 
	}

}
