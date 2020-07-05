package com.test04;

public class Car {

	// field 값은 초기화 하면 자동으로 초기값을 설정한다
	// String = null , int 값은 0
	
	private String color;
	private int speed;

	public Car() {

	}

	public Car(String color) {
		this.color = color;
	}
	
	public Car(String color, int speed) {
		this.color = color;
		this.speed = speed;

	}

	// getter & setter

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void accelPedal() {
		System.out.println("속도가 올라갑니다");
		speed = speed + 10;
	}

	public void breakPedal() {
		speed = speed - 10;

		if (speed > 0) {
			System.out.println("속도가 줄어듭니다");
		} else {
			System.out.println("멈췄습니다");
			speed = 0;
		}
	}
	
	public String toString() {
		return "현재 속도는" + speed + "입니다";
	}

}
