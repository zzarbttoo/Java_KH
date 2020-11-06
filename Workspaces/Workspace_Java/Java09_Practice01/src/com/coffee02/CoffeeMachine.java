package com.coffee02;

import java.util.Scanner;

public class CoffeeMachine {
	
	
	//메소는 하나의 기능만을 담당하게 만드는 것이 좋다
	public void inputMoney() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("돈을 넣어 주세요\n(한잔당 300원)");
		int money = sc.nextInt();
		
		System.out.println("몇잔을 원하시나요?");
		int cup = sc.nextInt();
		
		System.out.println("어떤 종류의 커피를 원하시나요? \n (일반은 0: 300원, 고급은 1: 700원)");
		int upgrade = sc.nextInt();
		
		
		makeCoffee(money, cup, upgrade);
	
	}

	private void makeCoffee(int money, int cup, int upgrade) {
		
		int money_up = 0;
		String ment= "";
		
		switch(upgrade) {
	
		case 0:
			money_up = 300;
			ment = "일반";
			break;
			
		case 1:
			money_up = 700;
			ment = "고급";
			break;
		
		}
		
		if( money >= cup * money_up) {
			
		System.out.println(ment +" 커피" + cup + "잔 나왔습니다");
		System.out.println("거스름돈은" + (money-cup*money_up)+ "원 입니다");
	
		}else {
			System.out.println("잔액이 부족합니다.");
		}
		return;
		
	}


}
