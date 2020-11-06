package com.test02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MTest02 {

	public static void main(String[] args) {

		File fi = new File("b.txt");

		myOutput(fi);
		myInput(fi);
	}

	public static void myInput(File fi) {

		FileReader fr=null;
	
		try {
		fr = new FileReader(fi);
		int ch;
		while((ch = fr.read()) != -1) {
			System.out.print((char) ch);
		}
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			//예외가 발생했든 아니든 닫아야하기 때문에 
			// finally 안에 trycatch
			try {
				fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	
	
	}

	public static void myOutput(File fi) {

		try {
			//FileWriter(fi, true) 이면 가장 뒤에다가 추가
			//FileWriter(fi, false)이면 덮어씌우기 한다
			FileWriter fw = new FileWriter(fi, true);
			fw.write("Java 재밌어...");
			fw.append("진짜 재밌어...").append("\n사실이야...\n");

			fw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
