package com.test;

import com.my.Score;

public class MTest {

	public static void main(String[] args) {
		
		//myScore이라고 배포한 라이브러리 안에 있다
		
		//jar : java ARchive : 라이브러리 배포하는 포맷
		Score hong = new Score();
		hong.setName("홍길동");
		hong.setKor(100);
		hong.setEng(80);
		hong.setMath(91);
		System.out.println(hong);
		
		//객체 배열 선언 방법 1
		/*
		Score[] qclass = new Score[3];
		qclass[0] = new Score("윤사라", 100, 100, 100);
		qclass[1] = new Score("장성윤", 70, 50, 40);
		qclass[2] = new Score("김보민", 70, 80, 90);
		*/
		
		// 객체 배열 선언 방법2
	
		/*
		Score[] qclass = new Score[] {
				new Score("윤사라", 100, 100, 100),
				new Score("장성윤", 70, 50, 90),
				new Score("김보민", 70, 80, 100)
		};
		
		*/
	
		//객체 배열 선언 방법3
		//new 연산자로 생성자 호출하면 객체
		//Score type의 값을 담아놓은 배열 
		Score[] qclass = {
				
				new Score("윤사라", 100, 100, 100), 
				new Score("장성윤", 70, 50, 90),
				new Score("김보민", 70, 80, 100)
		};
		
		
		
	}
	
}
