package com.test01;

//스레드 : 나눠서 각자 작업하게 하기 위해 배운다 

public class Thread04 {

	public static void main(String[] args) {
		
		MyThread03 my01 = new MyThread03("야옹이");
		MyThread03 my02 = new MyThread03("멍멍이");
		
		
		long startTime = System.currentTimeMillis();
		my01.start();
		try {
			
			//스레드의 기능인 join을 사용해봤다 
			my01.join();
			System.out.println("my01 끝나벌임");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		my02.start();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("실행시간" + (endTime - startTime));
		
		
	}
	
	
}
