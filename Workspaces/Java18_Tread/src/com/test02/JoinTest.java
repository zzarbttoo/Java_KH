package com.test02;

class MyCalc extends Thread {

	private int start;
	private int end;
	int sum;

	public MyCalc(int start, int end) {
		this.start = start;
		this.end = end;

	}

	public void run() {
		sum = 0;

		for (int i = start; i <= end; i++) {
			sum += i;
			System.out.println(currentThread().getName());
		}
	}
}

public class JoinTest {

	public static void main(String[] args) {

		MyCalc thread01 = new MyCalc(1, 5);
		MyCalc thread02 = new MyCalc(6, 10);

		thread01.start();
		thread02.start();

		try {
			//한번에 같이 join해야 둘이 번갈아가면서 할 수 있다
		
			thread01.join();
			thread02.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("thread01 :" + thread01.sum);
		System.out.println("thread02 :" + thread02.sum);
		System.out.println("total : " + (thread01.sum + thread02.sum));
	}

}
