package com.test02;

public class Cat extends Animal{

	@Override
	public void start() {
		System.out.println("야옹이 걷는다");
	}

	@Override
	public void stop() {
		
		System.out.println("야옹이 멈췄다");
	}

}
