package com.test03;

public class MTest {

	public static void main(String[] args) {
		int sumValue= MyCalc.mySum(10,3);
		System.out.println(sumValue);
		
		//MyCalc 클래스에 있는
		//mySub 메소드 호출
		//10이라는 값과 3이라는  값을 전달
		MyCalc.mySub(10, 3);
		
		//MyCalc class에 있는 myMul 호출
		//10, 3을 전달하고자 한다
		
		MyCalc my=new MyCalc();
		double mul=my.myMul(10.0, 3.0);
		System.out.println(mul);
		
		MyCalc.myDiv(10, 3);
		
	}
	
	
}
