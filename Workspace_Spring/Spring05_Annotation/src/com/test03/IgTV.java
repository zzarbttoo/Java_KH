package com.test03;

import org.springframework.stereotype.Component;

@Component
public class IgTV implements TV {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("ig tv power on");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub

		System.out.println("ig tv power off");

	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("ig tv volume on");

	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub

		System.out.println("ig tv volume off");
	}

}
