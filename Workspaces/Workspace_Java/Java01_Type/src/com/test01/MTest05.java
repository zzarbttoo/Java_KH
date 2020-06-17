package com.test01;

public class MTest05 {

	/*
	 * 기본타입		참조타입 
	 * 
	 * 1.byte		Byte
	 * 2.short		Short
	 * 3.int 		Integer
	 * 4.long		Long
	 * 
	 * 5.float		Float
	 * 6.double		Double
	 * 
	 * 7.char		Character
	 * 8.boolean	Boolean
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Byte의 범위 : " + Byte.MIN_VALUE+ "~" + Byte.MAX_VALUE); //-2^7~ 2^7-1  
		System.out.println("Short의 범위:" + Short.MIN_VALUE+ "~"+ Short.MAX_VALUE); //-2^15 ~ 2^15 -1 
		System.out.println("Integer의 범위"+ Integer.MIN_VALUE+ "~" + Integer.MAX_VALUE); //-2^31 ~ 2^31-1 
		System.out.println("Long의 범위"+ Long.MIN_VALUE + "~" + Long.MAX_VALUE); //-2^63 ~ 2^63-1
		System.out.println("Float의 범위" + Float.MIN_VALUE + "~" + Float.MAX_VALUE); //2^-149 ~ (2-2^-23)·2^127
		System.out.println("Double의 범위" + Double.MIN_VALUE + "~"+ Double.MAX_VALUE); //2^-1074 ~ (2-2^-52)·2^1023
		System.out.println("Character의 크기 " + Character.SIZE);
		
		System.out.println(Boolean.TRUE);
		
	
	}
}
