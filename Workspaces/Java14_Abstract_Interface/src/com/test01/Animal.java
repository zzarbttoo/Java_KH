package com.test01;

//추상 클래스 : 추상 메소드를 가질 수 있는 클래스 -> new 연산자 사용 불가!(객체 생성을 할 수 없다)
public abstract class Animal {
	//;으로 끝남
	//추상 메소드  : 상속 받는 자식 클래스가 "반드시" 구현!(반드시 override)
	//body 가 없기 때문에 연산자 사용 불가
	public abstract void bark();
	
	
	public void eat(String feed) {
		System.out.println(feed + "먹는다");
	}
	
}
