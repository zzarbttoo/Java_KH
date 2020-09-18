package com.pstm.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MultiClientThread extends Thread {

	Socket socket = null;
	BufferedReader standardinput; // 표준 입력 객체(키보드)
	BufferedWriter bufferWriter = null;
	BufferedReader bufferReader = null;

	public MultiClientThread(Socket tempSocket) {

		socket = tempSocket;

		try {
			bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("DEBUG-CT1 : 클라이언트 스레드 생성 ");
			// printwriter

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			String message = "";

			System.out.println("DEBUG-CT2 : 구동");
			while (!message.equals("bye")) {
				message = bufferReader.readLine();
				System.out.println(message);

				System.out.println("DEBUG-CT3 : 탈출");
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("multiclient run() 예외 발생");
		} finally {

			try {
				bufferReader.close();
				bufferWriter.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void chatProcess() {

		try {
			String message = "";

			while (!message.equals("bye")) {

				System.out.println("메시지를 입력하시오");
				message = standardinput.readLine();

				bufferWriter.write(message + "\n");
				bufferWriter.flush();

				System.out.println("DEBUG-CT1 : ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				bufferReader.close();
				bufferWriter.close();
				socket.close();
				System.out.println("chat process 종료");
				System.out.println("DEBUG-CT1 : ");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * // Client 로그인(ID 입력) public void login(){ try{ stdin = new BufferedReader(new
	 * InputStreamReader(System.in)); String result; String strId; do{
	 * //////////////////////////////////////////// // 1. Client ID 입력받기
	 * ////////////////////////////////////////////
	 * System.out.print("id를 입력하시오 ==> "); strId = stdin.readLine();
	 * ////////////////////////////////////////////
	 * 
	 * 
	 * /////////////////////////////// // 2. Server 로 Client ID 저장
	 * /////////////////////////////// //strId = strId +
	 * System.getProperty("line.separator"); bw.write(strId + "\n"); bw.flush();
	 * 
	 * //pw.println(strId); //pw.flush(); ///////////////////////////////
	 * 
	 * 
	 * // Server 로 'ok' 읽어오기(미리 입력된 아이디가 있을 경우 사용함.. 지금 사용해도 무관) result =
	 * br.readLine();
	 * 
	 * }while(!result.equals("ok"));
	 * 
	 * System.out.println("########### " + strId + "님 로그인 성공" + " ###########");
	 * 
	 * }catch(Exception e){ System.out.println(e.getMessage());
	 * System.out.println("login() 중 예외 발생"); } }
	 * 
	 */

}
