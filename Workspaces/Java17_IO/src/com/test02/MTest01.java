package com.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MTest01 {

	
	public static void main(String[] args) throws IOException {
		
		File fi = new File("a.txt");
		//가져오는 것 부터 하면 에러난다
		//그러므로 입력해주는 것부터 한다
		
		//checked exception이 발생하고 있다
		//public static void main ... throws IOExceptoin이라고 
		//throw해도 되나(실행하면 아무일도 안일어남), main 메소드는 자바 가상머신에 throw를 처리하는 메소드가
		//있는지 모르므로, 예외가 발생했을 때 내가 원하는대로 처리할 수 없다
		//throws를 남발하지 말자
		myOutput(fi);
		myInput(fi);
		
		
		
	}
	
	public static void myInput(File fi) throws IOException {
		
		FileInputStream fin = new FileInputStream(fi);
		
		int res = 0;
		//file의 끝이 아닐 때까지 
		while((res = fin.read()) != -1) {
			//char을 하지 않으면, ascii로 나오지 않고 숫자가 나온다
			System.out.println((char)res);
			
		}
		fin.close();
		
	}
	
	//throw는 exception 발생시킴
	//throws는 해당 메소드를 호출하는 애한테 예외를 위임하는 것
	//FileNotFoundExceptoin이 IO exception으로 변화함
	//그냥 exception으로 해도 된다
	public static void myOutput(File fi) throws IOException {
		//FileNotFoundException 이 많이 발생하니 예외처리 하시게
		
		//fileOutputStream이 자동으로 파일을 만들어놓는다
		FileOutputStream fo = new FileOutputStream(fi);	
		
		//숫자가 아니라 문자가 저장됐다
		for(int i= 65; i < 91; i++) {
			
			//byte 값을 Ascii code 값으로 생각해서 넣는다
			//int 를 byte 값으로 넣어서 거기에 맞는 ascii code를 넣는다
			//4byte 짜리 int를 byte 단위로 전송해야하므로, 3byte가 짤린다
			//이 값을 ascii code로 변한다
			fo.write(i);
		}
		
		//열었으면 닫아야한다
		fo.close();
		
	}
	
	
}
