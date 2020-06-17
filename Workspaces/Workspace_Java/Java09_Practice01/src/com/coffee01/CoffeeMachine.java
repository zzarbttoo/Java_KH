package com.coffee01;

import java.util.Scanner;

public class CoffeeMachine {

	
	//메소는 하나의 기능만을 담당하게 만드는 것이 좋다
	public void inputMoney() {
		System.out.println("돈을 넣어 주세요\n(한잔당 300원)");
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();
		if (money >= 300) {
			makeCoffee(money);
		} else {
			System.out.println("금액이 부족합니다");
		}
	}

	private void makeCoffee(int money) {
		int coffee = money / 300;
		int change = money % 300;
		System.out.println("커피" + coffee + "잔 나왔습니다");
		System.out.println("잔돈은" + change + "원 입니다");
		
		
	}

}
