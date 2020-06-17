package com.test03;

public class MyCalc {

	// 접근제한자 메모리영역 리턴타입 메소드명 (파라미터)
	public static int mySum(int a, int b) {
		int res= a + b;
	
		return res;
	}
	
	//void : 리턴할 값이 없을 때
	public static void mySub(int i, int j) {
		//빼기 : i-j
		int sub = i-j;
		//화면에 뺀 결과값 출력
		System.out.println(sub);
		
		return;
		
	}
	
	public double myMul(double i, double j) {
		
		double result = i * j;
		return result;
		
	}
	
	public static void myDiv(int i, int j) {
		
		//i/j : 몫
		int mok= i / j;
		//i%j : 나머지
		int namerge = i % j;
		
		System.out.printf("%d / %d 의 몫 : %d \n", i, j, mok);
		System.out.printf("%d %% %d 의 나머지 : %d", i, j, namerge);
		
	}
	
}
