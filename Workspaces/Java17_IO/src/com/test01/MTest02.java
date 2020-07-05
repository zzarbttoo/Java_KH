package com.test01;

import java.io.File;

public class MTest02 {

	public static void main(String[] args) {

		File fi = new File("c:\\");
		prn01(fi);

		prn02(fi);
	}

	public static void prn02(File fi) {

//		int dirSum = 0;
//		int fileSum = 0;
//		
//		for(File name : fi.listFiles()) {
//			
//			if(name.isDirectory()) {
//				
//				dirSum++;
//				System.out.println("dir : " + name.getName() );
//
//				
//				
//	
//		}else if(name.isFile()) {
//	
//			fileSum++;
//			System.out.println("File : " + name.getName());
//		}
//		}
//		
//		System.out.println("디렉토리 갯수" + dirSum);
//		System.out.println("파일 갯수" + fileSum);

		int cntFile = 0;
		int cntDir = 0;
		for (File f : fi.listFiles()) {

			if (f.isFile()) {
				System.out.println("file" + f);
				cntFile++;

			} else if (f.isDirectory()) {
				System.out.println("dir" + f);
				cntDir++;
			}
		}

		System.out.println("file 총 갯수" + cntFile);
		System.out.println("dir 총 갯수" + cntDir);
	}

	public static void prn01(File fi) {
		// c드라이브에 있는 모든 file 이름 출력
		for (String fileName : fi.list()) {
			System.out.println(fileName);
		}
	}
}
