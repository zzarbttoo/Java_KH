package com.bbb;

import com.aaa.AAA;

public class MTest {

	public static void main(String[] args) {

		//new와 함께 객체를 만들어주었다
		
// 생성만 해도
//		AAA 생성(기본 생성자)
//		BBB생성 (기본 생성자) 출력됨  -> 이때 AAA부터 만들어진다 ->이후 BBB가 만들어진다 
		BBB b1 = new BBB();
		
		//BBB에는 setAbc가 없고 AAA에게 있다 
		
		b1.setAbc(1); //AAA에 저장된다 -> 1이 저장된다
		b1.setB(2); //BBB에 저장된다 -> 2가 저장된다 
		
		
		System.out.println(b1.getSum());
		
		//BBB.prn() 이 출력된다
		b1.prn();
		
		//BBB b2 = new AAA(); 안됨 : 자식 타입으로 부모 객체를 받는 것은 안된다
		AAA b2 = new BBB(); // 됨  : 부모 타입으로 자식 객체를 받을 수는 있다 
		//BBB.prn() 이 출력된다  
		//type은 AAA 인데 BBB 객체이다 -> 메모리에는 AAA를 상속받는 BBB가 만들어진다 
		b2.prn();
		
		
		BBB b3 = new BBB(4, 5);
		System.out.println(b3.getSum());
		
		
	}

}
