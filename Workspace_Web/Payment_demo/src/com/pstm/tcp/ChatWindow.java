package com.pstm.tcp;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {
	private String name;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;

	public ChatWindow(String name, Socket socket) {
		this.name = name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;

		new ChatClientReceiveThread(socket).start();
	}

	//버튼이 눌러진다면 sendMessage 함수가 작동
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		

		// Textfield 
		//최대 입력 갯수는 80자
		textField.setColumns(80);
		//키보드를 누를 때 실행됨(addKeyListener)
		//enter을 눌러도 sendMessage 실행
		textField.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel <-css인거 같다 (패널레이아웃)
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea <-input text로 대체
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		//화면의 동작에 대해 하는 것이다
		frame.addWindowListener(new WindowAdapter() {
	
			//만약 x버튼 리스너 or 그냥 창 꺼버리는 리스너
			public void windowClosing(WindowEvent e) {
				PrintWriter pw;
				try {
					pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
					String request = "quit\r\n";
					pw.println(request);
					System.exit(0);
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.setVisible(true);
		frame.pack();
	}
	
	// 쓰레드를 만들어서 대화를 보내기
	private void sendMessage() {
		PrintWriter pw;
		try {
			//그 socket을 받아서, 새로운 printwriter을 만든다/autoflush
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			
			//input text의 값을 받아온다
			String message = textField.getText();
			
			//그 값을 printerwriter에 추가한다
			String request = "message:" + message + "\r\n";
			pw.println(request);
			
			
			textField.setText("");
			//포커스를 통해 먼저 여기 키를 입력받는다고 한다..(하지만 자바스크립트에서 필요한지는 의문)
			textField.requestFocus();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ChatClientReceiveThread extends Thread{
		Socket socket = null;
		
		ChatClientReceiveThread(Socket socket){
			this.socket = socket;
		}

		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while(true) {
					String msg = br.readLine();
					textArea.append(msg);
					textArea.append("\n");
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
