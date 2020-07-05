package com.test04;

//class - class (단일 상속) - interface(다중 상속)
public class Eagle extends Animal implements Bird {

	@Override
	public void fly() {
		System.out.println("퍼덕퍼덕");
	}

	@Override
	public void bark() {
		System.out.println("끼약?");
	}

}
