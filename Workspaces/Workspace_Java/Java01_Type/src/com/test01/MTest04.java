package com.test01;

public class MTest04 {

	// 문자형 'char'(2), 논리형 boolean(1)
	// 문자열 "String"
	public static void main(String args[]) {
		char c01='a';
		System.out.println(c01);
		char c02='b';
		int c03=c02; //ascii code
		System.out.println(c03);
		
		String s01="ab";
		System.out.println(s01);
		String s02="cdefg";
		System.out.println(s02);
		System.out.println(s01+s02);
		
		char last_name='\ubc30';
		System.out.println(last_name);
		
		System.out.println("--------------------------------------");
		
		
		boolean bl01=true; // 참
		boolean bl02=false; // 거짓
		System.out.println(bl01);
		System.out.println(bl02);
		
		
		
	}
	
}
