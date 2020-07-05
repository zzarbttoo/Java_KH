package com.test03;

public class MTest {

	
	//값을 무엇을 주든 일단 더하는 기능을 다 해주었다
	//overload : 파라미터의 갯수나 타입이 다른 상태에서 같은 이름으로 다른 기능을 하는 것이 오버로딩(리턴 타입은 상관이 없다)
	public static void main(String[] args) {
		MySum my = new MySum();
		System.out.println(my.sum(10));
		System.out.println(my.sum(20, 30));
		System.out.println(my.sum(40, 50, 60));
		System.out.println(my.sum(1.5, 2.7));
	}
	
}
