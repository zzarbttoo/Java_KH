package com.cal.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {

	private String toDates;
	
	

	public String getToDates() {
		return toDates;
	}



	public void setToDates(String mdate) {
		
		//mdate(yyyyMMddhhmm) 의 형식을 yyyy-MM-dd hh:mm:00으로 변환
		String m = mdate.substring(0,4) + "-"
				+ mdate.substring(4, 6) + "-"
				+ mdate.substring(6, 8) + " "
				+ mdate.substring(8, 10) + ":" 
				+ mdate.substring(10) + ":00";
		
		//날짜를 yyyy년~ 의 문자 형태로 바꾸고 싶은 것이다 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		//string을 날짜 형태로 바꾸고
		Timestamp tm = Timestamp.valueOf(m);
		//그 날짜 형태를 다시 yyyy년MM월dd일HH시mm분 이라고 바꿨다
		toDates = sdf.format(tm);
		
		System.out.println("날짜 제대로 찍히냐냐ㅑㄴ" + mdate);
		
	}



	// msg가 한글자짜리이면 두글자로 바꿔주라줘
	public static String isTwo(String msg) {

		/*
		 * if (msg.length() == 1) {
		 * 
		 * return "0" + msg;
		 * 
		 * } else {
		 * 
		 * return msg; }
		 * 
		 */

		return (msg.length() < 2) ? "0" + msg : msg;

	}
	
	public static String fontColor(int date, int dayOfWeek) {
		
		String color = "";
		
		//date : 1...n 일의 요일 숫자 
		//dayOfweek - 1 은 1일 전날 의 요일 숫자 
		
		if((dayOfWeek - 1 + date) % 7 == 0) {
			
			color = "blue";
			
		}else if((dayOfWeek-1+date)%7 == 1) {
			
			color = "red";
		}else {
			
			color = "black";
		}
		
		return color;
	}
	
	public static String getCalView (int i , List<CalDto> clist) {
		
		String res = "";
		
		String day = isTwo(i+"");
		System.out.println(i);
		for(CalDto dto : clist) {
			
			System.out.println(dto.getMdate());
			//yyyyMMddHHmm
			//오늘 날짜라면, 오늘 날짜에 해당하는 글들을 p태그로 만들어서 리턴해줄 것이다 
			if(dto.getMdate().substring(6, 8).equals(day)) {
				res += "<p>" +((dto.getTitle().length()>6)?dto.getTitle().substring(0,6)+"...":dto.getTitle())+"</p>";
				
			}
			
		}
		
		
		return res;
		
	}

}
