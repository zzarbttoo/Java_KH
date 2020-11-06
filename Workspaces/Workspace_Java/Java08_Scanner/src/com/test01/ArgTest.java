package com.test01;

public class ArgTest {

	// run as -> run configurations -> arguments -> ${stirng_prompt}
	// 공백을 기준으로 아규먼트 값들이 들어간다 
	public static void main(String[] args) {
	
		String s = args[0];
		System.out.println(s);
		
		
		for (int i=0 ; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
	}
}
