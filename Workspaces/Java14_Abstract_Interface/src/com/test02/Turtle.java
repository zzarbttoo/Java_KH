package com.test02;

public class Turtle extends Animal{

	@Override
	public void start() {
		System.out.println("거북이 걷는다");
	}

	@Override
	public void stop() {
		System.out.println("거북이 멈췄다.");
	}

}
