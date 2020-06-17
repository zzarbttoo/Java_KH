package com.test02;

public class MTest02 {

	public static void main(String[] args) {
		//Wrapper Class: 기본 타입을 참조 타입으로 바꿈
		//참조 타입 : 주소값 
		//type 변수 = new type(); 여기서 new type이 값이다 
		
		//Boxing : 값(기본 타입) -> 참조타입 
		Integer i = new Integer(100);
		System.out.println(i);
		
		//unBoxing : 참조타입 -> 기본타입(값)
		//명시적
		int j=i.intValue();
		//묵시적
		int k=i;
		
		System.out.println(j);
		System.out.println(k);
		
	}
	
}
