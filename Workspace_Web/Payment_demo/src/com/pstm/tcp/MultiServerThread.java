package com.pstm.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MultiServerThread extends Thread {

	private Socket socket;
	private BufferedReader bufferReader = null;
	private BufferedWriter bufferWriter = null;

	String strId;
	boolean isLogin;
	MultiChatRoom chatRoom;

	public MultiServerThread(Socket tempSocket, MultiChatRoom tempChatroom) {
		socket = tempSocket;
		chatRoom = tempChatroom;
		System.out.println("DEBUG-ST : 서버 스레드 생성");

		try {
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {

		// 메시지 전송
		try {

			System.out.println("DEBUG-ST2 : 서버 스레드 메시지");
			message = message + System.getProperty("line.seperator");
			bufferWriter.write(message + "\n"); // 줄바꿈
			bufferWriter.flush(); // 출력 버퍼를 비우는 메서드
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {

		System.out.println("DEBUG-ST3 : 서버 스레드 구동");
		String message = "";
		// 로그인 처리<-client 아이디 받아오기

		while (!message.equals("bye")) {

			try {
				message = bufferReader.readLine();

				System.out.println("DEBUG-ST4 : 서버 글 읽기");
				System.out.println("받은 메시지" + message);

				if (message.equals("bye")) {

					System.out.println("DEBUG-ST5 : 서버  퇴장");
					chatRoom.broadCasting(strId + "님이 퇴장하셨습니다");
				}

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("메시지 수신하여 송신 중 예외 발생");
			} finally {
				chatRoom.exitRoom(this);

				try {
					bufferWriter.close();
					bufferReader.close();
					// 패스워드 close
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("multiServerThread 종료");
			}

		}

	}

	// 임시로 id 설정을 만들어줌(나중에는 디비로 바꿔야지)
	public void setStrId(String strId) {
		this.strId = strId;
	}

	/*
	 * // 로그인 (Client 에서 Server 로 ID 전송해서 받음) public void login(){ //String
	 * members[] = {"이예진", "조수희", "조아란"}; //접속 가능한 아이디가 3개만 존재한다고 가정한다. //String
	 * tempId = null;
	 * 
	 * try{ System.out.println("Client ID 받아오는 중...."); br = new BufferedReader(new
	 * InputStreamReader(socket.getInputStream()));
	 * 
	 * /////////////////////////////////////////////// // Client 가 입력한 ID 받아오기
	 * /////////////////////////////////////////////// //tempId = br.readLine();
	 * strId = br.readLine(); //System.out.println("Client ID : " + strId);
	 * 
	 * /////////////////////////// // 3. 접속자 수 보여주기 ///////////////////////////
	 * multiChatRoom.display(); ///////////////////////////
	 * 
	 * sendMessage("ok"); //System.out.println("서버 - 로그인 이름 확인");
	 * ///////////////////////////////////////////////
	 * 
	 * }catch(IOException e){
	 * System.out.println("MultiServerThread2 login() 예외 발생"); } }
	 * 
	 */

}
