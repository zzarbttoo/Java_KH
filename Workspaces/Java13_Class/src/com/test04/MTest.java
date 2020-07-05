package com.test04;

public class MTest {

	public static void main(String[] args) {

		Car c1 = new SportsCar("빨강");
		c1.accelPedal();
		c1.accelPedal();
		c1.accelPedal();
		c1.accelPedal();
		c1.accelPedal();
		System.out.println(c1);
		c1.breakPedal();
		c1.breakPedal();
		c1.breakPedal();
		c1.breakPedal();
		c1.breakPedal();
		c1.breakPedal();
		c1.breakPedal();
		
		System.out.println(c1);

		Car c2 = new Truck("파랑");
		c2.accelPedal();
		c2.accelPedal();
		System.out.println(c2);
		c2.breakPedal();
		c2.breakPedal();
		c2.breakPedal();
		System.out.println(c2);
	}
}
