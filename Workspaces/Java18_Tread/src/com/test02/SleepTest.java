package com.test02;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			
			//0.5초마다 하나씩 하트가 증가한다
			//main스레드가 while을 반복할텐데
			//Thread.sleep을 할 때마다 0.5마다 잔다
			
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(500);
				System.out.printf("%c", '♥');
			}
			System.out.println();
		}
		
	}
}
