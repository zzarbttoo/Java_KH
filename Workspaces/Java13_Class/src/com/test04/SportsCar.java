package com.test04;

public class SportsCar extends Car{

	
	public SportsCar() {
		System.out.println("sports car 생성");
	}
	
	public SportsCar(String color) {
		System.out.println(color + "색 sports car 생성");
	}
	
	@Override
	public void accelPedal() {
		//"속도가 더 빠르게 올라갑니다"
		// + 30
		//speed 에는 직접 접근할 수 없다
//		super.setSpeed(super.getSpeed() + 30);
		//부모 클래스에 있는 건 그대로 쓸 수 있어서 super. 안붙여도 된다
		setSpeed(getSpeed() + 30);
		System.out.println("속도가 더 빠르게 올라갑니다");
		
	}
	
	@Override
	public void breakPedal() {
		//"속도가 더 빠르게 내려갑니다"
		// - 30
		super.setSpeed(super.getSpeed()-30);
		if(super.getSpeed() > 0) {
			System.out.println("속도가 더 빠르게 내려갑니다");
		}else {
			System.out.println("멈췄습니다");
			//speed가 음수가 될 수 있기 때문
			super.setSpeed(0);
		}
	}
	
	@Override
	public String toString() {
	
		//sports car의 현재 속도는 -- 입니다
//		System.out.println("sports car의 현재 속도는" + super.getSpeed() + "입니다");
		//return "sports car의 현재 속도는 " + getSpeed() + "입니다";
		//만약 super.toString() 에서 super 생략하면 재귀 함수가 호출돼서 난리 버거지 된다
		return "sports car의" + super.toString();
	}
	
}
