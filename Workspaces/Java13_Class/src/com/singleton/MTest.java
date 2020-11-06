package com.singleton;

import java.util.Calendar;

public class MTest {

	public static void main(String[] args) {
		
		//생성자를 private으로 만들면 new 생성자(); 사용 불가!
//		Singleton singleton = new Singleton();
		
		
		//s01과 s02 의 주솟값이 모두 같은 것을 확인할 수 있다
		Singleton s01 = Singleton.getInstance();
		System.out.println(s01);
		
		Singleton s02 = Singleton.getInstance();
		System.out.println(s02);
		
		System.out.println(s01 == s02);
		
		//객체를 가져오자
		//보통 getInstance라고 하면 singleton 패턴의 값을 가져오는 것이다
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
