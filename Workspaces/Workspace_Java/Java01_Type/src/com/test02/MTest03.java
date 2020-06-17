package com.test02;

public class MTest03 {

	public static void main(String[] args) {
		
		//1. char-> int : Ascii code로 A는 65
		char c01='A';
		int i01=c01;
		System.out.println(i01);
		
		//2. int -> char
		int i02=66;
		char c02=(char)i02;
		System.out.println(c02);
		
		//3. char-> int 
		char c03='1';
		char c04='9';
		int sum=c03 + c04;
		System.out.println(sum);
		
		//4. String -> int 
		String str= "25";
		int i03 = Integer.parseInt(str) + 1; //parseInt는  wrapper class의 기능이다
		System.out.println(i03);
		System.out.println(str + 1);
		
		//5. int -> String
		int i04 = 65;
		String str02=String.valueOf(i04);
		System.out.println(str02 + 1);
		String str03=Integer.toString(i04);
		System.out.println(str03 + 1);
		
	}
}
