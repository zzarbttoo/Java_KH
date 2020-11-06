package com.test01;

class MyThread03 extends Thread {

	public MyThread03(String name) {
		super(name);
	}

	@Override
	public void run() {

		for (int i = 0; i < 500; i++) {

			System.out.println(this.getName() + ":" + i);
		}

		System.out.println(this.getName() + "끝!!!!");

	}
}

public class Thread03 {

	public static void main(String[] args) {

		MyThread03 my01 = new MyThread03("야옹이");
		MyThread03 my02 = new MyThread03("멍멍이");

		
		//java의 thread scheduling은 우선순위(priority)와 순환할당(round-robin)방식을 사용한다
		//우선순위가 높을 수록 좋지만(priority), 우선순위가 높다고 항상 먼저 끝나는 것은 아니다
		my01.setPriority(10);
		my02.setPriority(Thread.MIN_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		my01.start();
		my02.start();
		System.out.println(my01.getName() + ">" + my01.getPriority());
		System.out.println(my02.getName() + ">" + my02.getPriority());
	}
}
