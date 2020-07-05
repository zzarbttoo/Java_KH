package com.test01;

import java.io.File;
import java.io.IOException;

public class MTest01 {

	public static void main(String[] args) {
		
		
		File fi = new File("C:/test_io");
		
		if(fi.exists()) {
			System.out.println("exists");
		}else {
			
			System.out.println("new");
			fi.mkdir();
		}
		
		//test_io 아래에 "AA" 파일이 만들어졌다
		File fiaa = new File(fi, "AA");
		fiaa.mkdir();
		
		// \\ 왜 두번 붙임? ->  \t, \n 과 같이 \\ 여서 라고 한다!!!!!!!!!!!!!!!! 
		File fibb = new File("c:\\test_io", "BB");
		fibb.mkdir();
		
		File aaTxt = new File(fiaa, "a.txt");
		try {
			aaTxt.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
