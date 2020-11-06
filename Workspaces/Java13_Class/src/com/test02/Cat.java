package com.test02;

public class Cat extends Animal{

	public Cat() {
		System.out.println("냐옹이");
	}
	
	public void bark() {
		
		//부모클래스의 bark를 호출했다
		super.bark();
		System.out.println("냐옹");
	}
	
}
