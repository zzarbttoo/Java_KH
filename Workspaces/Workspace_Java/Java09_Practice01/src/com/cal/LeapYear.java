package com.cal;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input year : ");
		int year = sc.nextInt();

		if (isLeapyear(year)) {
			System.out.println(year + "년도는 윤년이 맞습니다");
		} else {
			System.out.println(year + "년도는 윤년이 아닙니다");
		}
	}

	private static boolean isLeapyear(int year) {

//		boolean leap = false;
//
//		if (year % 4 == 0) {
//
//			if (year % 100 == 0 && year % 4 == 0) {
//				leap = true;
//			}
//
//		}
//
//		return leap;
		
		boolean leap = false;
		
		if((year % 4 == 0 && year % 100!=0 )|| year % 400 == 0) {
			leap = true;
		}
		
		return leap;
	}

}
/*
 * ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고 ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, ③ 다만
 * 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다. 이로써 1년의 평균길이를 365.2425일로 정하여 역에 썼으므로 실제의 1년보다
 * 0.0003일이 길다.
 */