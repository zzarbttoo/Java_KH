package com.cal02;

import java.util.Calendar;

//java.util.calendar class를 이용해 해당년도 해당월을 입력하면, 
//그 월의 달력을 출력하는 함수를 만들어오시오
public class CalendarUseApi {

	public void calPrn(int year, int month) {
		
		//Calendar 객체 생성
		Calendar cal = Calendar.getInstance();
		
		//윗부분
		System.out.printf("\t\t%d 년 %d 월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//1.
		
//		cal 객체의 필드를  년, month-1, 1일 값으로 초기화한다
//		1월 = 0 , 12 월은 11 이므로 -1을 해줬어요
//		그러므로 cal객체는 여기서는 저희가 입력해준 년/월의 1일이 저장 됨
		
		//해당 년도 해당 일의 1일을 저장하자
		cal.set(year, month-1, 1);
		
		//2. 
		
		//그 날의 요일을 리턴해준다 Sunday~ 
		
		//DAY_OF_WEEK <-enum Class이다 
		//Sunday : 1 
		//calendar에서 가지고 오자 해야 우리가 원하는 값을 가지고 올 수 있다
		int start = cal.get(Calendar.DAY_OF_WEEK);
		
		//3.
		//요일 만큼, 빈칸을 입력해줘요~(탭탭)
		
		for(int i = 1; i < start; i++) {
			System.out.printf("\t");
			
		}
		
		System.out.println(cal.getActualMaximum(Calendar.MONTH));
		
		//4. 
		//Calendar.Date -> 일단위를 입력
		//getActualMaximum 은 -> 해당 입력 한 것의 최대 값 반환
		//일은 그 월의 최대 일을 반환, 월이라면 12을 반환
		//그래서 그 최대 일을 반환한다
		
		
		for(int i = 1; i<=cal.getActualMaximum(Calendar.DATE); i++) {
			
			System.out.printf("%d\t", i);
		
			//탭 이후부터 시작
			//7이 되면 줄바꿈
			if(start%7 == 0) {
				System.out.println();
			}
			
			//계속 출력
			start++;
		}
		
		
		
		
	}
	
}
