package com.test01;

//간단하게 쓰레드화 시킬 때 Runnable implements
class MyThread implements Runnable{

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
	
}


public class Thread01 {

	public static void main(String[] args) {
		System.out.println("main start--------------------");
		
		//일반적인 자바의 호출 방식
		//쓰레드 아니다!
//		MyThread my01 = new MyThread();
//		MyThread my02 = new MyThread();
//		my01.run();
//		my02.run();
		
		
		//Thread 이다! 
		Thread my01 = new Thread(new MyThread());
		Thread my02 = new Thread(new MyThread());
		my01.start(); //자동으로 run() 호출! 
		my02.start();
		
		System.out.println("main end--------------------");
	}
	
	
	
	
}
