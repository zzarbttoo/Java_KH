package com.test01;

public class MTest01 {

	public static void prn01() {
		//if 는 순차적으로 조건을 확인
		//switch는 특정 case로 jumping
		// fall through : 특정 case 부터 아래에 있는 명령을 모두 수행
		int i = 2;
		
		switch(i) {
		case 1:
			System.out.println("1입니다"); 
			break;
		case 2:
			System.out.println("2입니다");
			break;
		case 3:
			System.out.println("3입니다");
			break;
		case 4:
			System.out.println("4입니다");
			break;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		prn01();
		prn02();
		prn03('a');
	}
	
	
	public static void prn03(char c) {
		switch(c) {
		
		case 'a' :
			System.out.println("a 입니다");
			break;
		case 'b' : 
			System.out.println("b 입니다");
			break;
		case 'c' : 
			System.out.println("c 입니다");
			break;
		default:
			System.out.println("f 입니다.");
		}
	}
	
	public static void prn02() {
		int i = 2;
		
		switch(i) {
		case 1:
		case 3:
			System.out.println("홀수입니다");
			break;
		case 2:
		case 4:
			System.out.println("짝수입니다");
			break;
		
		default:
			System.out.println("1, 2, 3, 4만 입력해 주세요.");
		
		}
	}
	
	
	
}
