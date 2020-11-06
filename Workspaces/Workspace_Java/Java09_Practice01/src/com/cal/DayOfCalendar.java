package com.cal;

import java.util.Scanner;

//년 월 일이 주어지면 , 해당 년 원 일의 요일을 출력하자
//단 Calendar class 사용 금지
public class DayOfCalendar {

//(1년 1월 1일 ~ year month day ) % 7 = 0 ~ 6 (0: 일요일 1:월요일 2:화 ...)
	public static void main(String[] args) {
		
		//총 일수 계산
		int sum = 0;
		int year = 2020;
		int month = 6;
		int day = 17;
		
		
		//1년 1월 1일 ~ 2019년 12 월 31 일 
		for (int i = 1; i < year ; i++) {
			for (int j = 1; j < 13; j++) {
				
				sum +=dates(i, j);
			}
		}
		
		//2020년 1월 1일 ~ 2020년 5월 31일
		for (int k = 1; k < month; k++) {
			sum +=dates(year ,k);
		}
		
		sum += day;
		
		
		//나눈 나머지 계산 
		int result = sum % 7 ;
		System.out.printf("%d년 %d월 %d일은 %s입니다", year, month, day, dayToKorean(result));
		
		
		
		

//	int year;
//	int month;
//	int date;
//	
//	//1900년도 이상의 년도에만 적용이 가능하다 
//	Scanner sc = new Scanner(System.in);
//	System.out.println("년도를 입력하시오");
//	year = sc.nextInt();
//	System.out.println("월을 입력하시오");
//	month = sc.nextInt();
//	System.out.println("일을 입력하시오");
//	date = sc.nextInt();
//	yoon(year, month, date);
//	sc.close();
//	
//}
//	
//
//public static void yoon(int i, int j, int k) {

//	boolean yoon = false;
//	int today = 0;
//	int sD = 0;
//	int sD_bM = 0;
//	int monthD[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//	int sD_bM_s=0;
//	
//
//	// 윤년 여부인지 출력
//	if (i % 4 == 0) {
//
//		if (i % 100 == 0 && i % 400 == 0) {
//			System.out.println(i + "년은 윤년입니다");
//			yoon = true;
//		}
//		if (i % 400 != 0) {
//			System.out.println(i + "년은 평년입니다");
//		}
//	} else {
//		System.out.println(i + "년은 평년입니다");
//	}
//
//	today += (i - 1900) * 365;
//	today += (i - 1900) / 4;
//
//	if (yoon && (j == 2 || j == 1)) {
//		today--;
//	}
//
//	for (int t = 1; t < j; t++) {
//
//		
//			sD_bM += monthD[t-1];
//
//	}
//	today += sD_bM;
//	today -= 1;
//	sD_bM_s = (today) % 7;
//	today += k;
//	
//
//	sD = today % 7;
//
//	switch (sD) {
//	case 0:
//		System.out.println("Sunday");
//		break;
//	case 1:
//		System.out.println("Monday");
//		break;
//	case 2:
//		System.out.println("Tuesday");
//		break;
//	case 3:
//		System.out.println("Wednesday");
//		break;
//	case 4:
//		System.out.println("Thursday");
//		break;
//	case 5:
//		System.out.println("Friday");
//		break;
//	case 6:
//		System.out.println("Saturday");
//		break;
//
//	}
//	
//
//	// 달력 출력
//
//	System.out.println("========" + i + "년" + j + "월" + "=======");
//	System.out.printf("%3s  %3s  %3s  %3s  %3s  %3s  %3s", "일", "월", "화", "수", "목", "금", "토");
//	System.out.println();
//	
//	
//	
//	//너무 년도가 짧으면 출력 안되는 문제 있음
//	// 윤년 출력은 잘 되는가?
//	for(int t2 = 0; t2 < sD_bM_s + monthD[j - 1] + 2; t2++) {
//		
//		if(t2 <= sD_bM_s + 1) {
//			System.out.printf("%3s", " ");
//		}else {
//			System.out.printf("%3d", t2 - sD_bM_s -1);
//		}
//		if(t2 % 7 == 0) {
//			System.out.println();
//		}
//	}
//	
//	
//	

	}

	public static boolean isLeapYear(int year) {
		

		boolean leap = false;
		
		if((year % 4 == 0 && year % 100!=0 )|| year % 400 == 0) {
			leap = true;
		}
		
		return leap;
	}
	
	
	public static int dates(int year, int month) {
		
		int temp = 0;
		
		if(isLeapYear (year)) {
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: 
				temp = 31;
			break;
			
			case 4:
			case 6:
			case 9:
			case 11:
				temp = 30;
			break;
			
			case 2:
				temp = 29;
				break;
			}
			}else {
				
				if(month == 1 || month == 3 || month == 5 || month ==7 || month ==8 || month == 10 || month ==12) {
					temp = 31;
				}else if(month == 4 || month == 6 || month == 9 || month == 11 ) {
					temp = 30;
				}else {
					temp = 28;
				}
			}
		
		return 0;
	}
	
	public static String dayToKorean(int day) {
		//switch case 할 때는 꼭 default 써서 return 하도록 해줘야한다
		switch(day) {
		case 0:
			return "일요일";
		case 1:
			return "월요일";
		case 2:
			return "화요일";
		case 3:
			return "수요일";
		case 4:
			return "목요일";
		case 5:
			return "금요일";
		case 6:
			return "토요일";
		}
		return null;
	}
}
