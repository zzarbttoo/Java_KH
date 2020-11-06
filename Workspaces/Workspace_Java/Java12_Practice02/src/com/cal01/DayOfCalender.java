package com.cal01;

import java.util.Scanner;

public class DayOfCalender {

	// 윤년 계산 -> 해당 년도 해당 월의 일수 계산 시 필요
	public static boolean isLeapYear(int year) {

		boolean leap = false;

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			leap = true;
		}

		return leap;

	}

	// 일수 계산 -> 해당 년도 해당 월의 일수 리턴
	public static int dates(int year, int month) {

		int date = 0;

		// true -> 윤년 , false -> 윤년이 아님
		if (isLeapYear(year)) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				date = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				date = 30;
				break;

			case 2:
				date = 29;
				break;
			}
		} else {

			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				date = 31;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				date = 30;
			} else {
				date = 28;
			}
		}

		return date;

	}

	// 요일 계산 -> 입력한 년도의 입력한 월의 1일의 요일 리턴
	// 0 : 일요일 ~ 6 : 토요일
	public static int whatDay(int year, int month) {
		
		int dayOfWeek = 0;
		int sum = 0;
		
		
		// 1년 1월 1일~ year-1 년 12월 31일까지의 합
		for(int i = 1; i < year ; i++) {
			for(int j = 1; j <=12; j++) {
				sum +=dates(i, j);
			}
		}
		
		
		// year년 1월 1일 ~ year년 month -1 월 마지막일 합
		for(int k = 1; k < month; k++) {
			sum += dates(year, k);
			
		}
		
		// year 년 month월 1일 
		sum += 1;
		//요일 계산
		dayOfWeek = sum % 7; 
		return dayOfWeek;
		
	}

	// 달력 출력
	public static void prn(int year, int month) {

		System.out.printf("\t\t%d 년 %d월 \n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		// 시작요일

		int start = whatDay(year, month);
		
		// 마지막요일

		int last = dates(year, month);
		
		// 시작 요일만큼 빈공간

		for(int i = 0; i < start; i++) {
			System.out.print("\t");
		}
		// 출력(~ 마지막요일)

		for (int i =1; i <= last ; i++) {
			System.out.printf("%d\t", i);
			start++;
			if(start % 7 == 0) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

//		
//		int year;
//		int date;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("년도를 입력하시오");
//		year = sc.nextInt();
//		System.out.println("월을 입력하시오");
//		date = sc.nextInt();
//		
//		printCal(year, date);

	}

//	private static void printCal(int i, int j) {
//		
//		boolean yoon = false;
//		int today = 0;
//		int sD = 0;
//		int sD_bM = 0;
//		int monthD[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//		int sD_bM_s=0;
//		
//
//		// 윤년 여부인지 출력
//		if (i % 4 == 0) {
//
//			if (i % 100 == 0 && i % 400 == 0) {
//				yoon = true;
//			}
//			if (i % 400 != 0) {
//			}
//		} else {
//		}
//
//		today += (i - 1900) * 365;
//		today += (i - 1900) / 4;
//
//		if (yoon && (j == 2 || j == 1)) {
//			today--;
//		}
//
//		for (int t = 1; t < j; t++) {
//
//			
//				sD_bM += monthD[t-1];
//
//		}
//		today += sD_bM;
//		today -= 1;
//		sD_bM_s = (today) % 7;
//		
//
//		sD = today % 7;
//
//		
//		
//
//		// 달력 출력
//
//		System.out.println("========" + i + "년" + j + "월" + "=======");
//		System.out.printf("%3s  %3s  %3s  %3s  %3s  %3s  %3s", "일", "월", "화", "수", "목", "금", "토");
//		System.out.println();
//		
//		for(int t2 = 0; t2 < sD_bM_s + monthD[j - 1] + 2; t2++) {
//			
//			if(t2 <= sD_bM_s + 1) {
//				System.out.printf("%3s", " ");
//			}else {
//				System.out.printf("%3d", t2 - sD_bM_s -1);
//			}
//			if(t2 % 7 == 0) {
//				System.out.println();
//			}
//		}
//		
//		
//		
//	}
//	

}
