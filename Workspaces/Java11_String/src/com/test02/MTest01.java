package com.test02;

public class MTest01 {

	public static void main(String[] args) {
		stringBufferTest();
		stringTest();
	}
	
	
	//StringBuffer 
	public static void stringBufferTest() {
		StringBuffer sb = new StringBuffer();
		sb.append("안녕하세요").append("제 이름은").append("배유진입니다");
		
		System.out.println(sb);
		System.out.println(sb.hashCode());
		
		//mutable
		sb.replace(0, 5, "하이");
		System.out.println(sb);
		System.out.println(sb.hashCode());
		
		sb.reverse();
		System.out.println(sb);
		
		
	}
		
		//String
		public static void stringTest() {
		
			//java는 내부적으로 +연산 시 StringBuilder를 사용한다(1.5 이후)
			String s = "안녕하세요";
			s += "제 이름은";
			s += "이동헌 입니다.";
			System.out.println(s);
			System.out.println(s.hashCode());
			
			//imputable
			s.replace("안녕하세요", "하이");
			System.out.println(s);
			
			s= s.replace("안녕하세요", "하이");
			System.out.println(s.hashCode());
			
		}
		
		
	
	}
