package com.test04;

public class Truck extends Car {

	public Truck() {
		System.out.println("truck 생성");
	}

	public Truck(String color) {
		super(color);
		System.out.println(color + "색 truck 생성");
	}

	public void accelPedal() {
		// 속도가 적당히 올라갑니다
		// + 20
		System.out.println("속도가 적당히 올라갑니다");
		super.setSpeed(super.getSpeed() + 20);
	}

	public void breakPedal() {
		// 속도가 적당히 내려갑니다
		// - 20
		super.setSpeed(super.getSpeed() - 20);
		if (super.getSpeed() > 0) {
			System.out.println("속도가 적당히 내려갑니다");
		} else {
			System.out.println("멈췄습니다");
			super.setSpeed(0);
		}
	}

	public String toString() {
		return getColor() + "색 truck의 " + super.toString();
	}
}
