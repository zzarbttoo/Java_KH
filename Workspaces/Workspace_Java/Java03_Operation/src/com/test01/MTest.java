package com.test01;

//카멜 표기법
//class: 첫글자 대문자, 새로운 단어가 나올 때 대문자
//method: 첫글자 소문자, 새로운 단어가 나올 때 대문자
public class MTest {

	//필드
	//(static) final : 상수화
	public static final int TEN = 10;
	
	
	
	
	public static void main(String[] args) {
		
		opr01(3);
		System.out.println(opr02());
		opr02();
		
		opr03(TEN, 3);
		
		System.out.println("opr04 :" + opr04());
		opr05();
		opr06();
		opr07();
	}
	
	//1. 사칙연산
	public static void opr01(int a) {
		
		System.out.printf("%d + %d = %d\n", TEN, a , TEN + a);
		System.out.printf("%d - %d = %d\n", TEN, a, TEN - a);
		System.out.printf("%d * %d = %d\n", TEN, a, TEN * a);
		System.out.printf("%d / %d = %d\n", TEN, a, TEN / a);
		System.out.printf("%d %% %d = %d\n", TEN, a, TEN % a);
		
	}
	
	//2. 대입 연산 (=, +=, -=, *=, /=, %=)
	public static String opr02() {
		
		int res = 0;
		System.out.println(res); //0
		
		res = res + 10;
		System.out.println(res); //10
		
		res -= 5;
		// res = res - 5;
		System.out.println(res);
		
		return "대입 연산 끝!!!";
	}
	
	
	// 3. 증감 연산 (++, --)
	// 변수의 앞/뒤에 증감 연산자가 붙어서, 해당 변수의 값을 1씩 증가 혹은 감소시킨다. 
	// (앞) 전위 연산자 : 연산자를 변수 앞에 붙이면, 연산을 먼저 하고 값을 나중에 리턴한다
	// (뒤) 후위 연산자 : 연산자를 변수 뒤에 붙이면, 값을 먼저 리턴하고 연산을 나중에 한다 
	public static void opr03(int a, int b) {
		
		System.out.println(a); //10 출력
		System.out.println(a++); //10 출력(11)
		System.out.println(++a);//12 출력 
		System.out.println(a);
		
		//			12(13) + 2(2) + 2(3) + 14(14) 
		int result = a++ + --b + b++ + ++a;
		
		System.out.println(result);
		
	}
	
	// 4. 논리연산 : &&, || -> true, false
	public static boolean opr04() {
		
		System.out.println(true & true); //true
		System.out.println(true & false); //false 
		System.out.println(false & true); //false
		System.out.println(false & false); // false
		System.out.println(true | true); // true
		System.out.println(true | false); //true
		System.out.println(false | true); //true
		System.out.println(false | false); // false
		
		System.out.println("----------------------");
		
		System.out.println(true && true); //true
		System.out.println(true && false); //false //뒤에 dead code라고 쓰이는건 &&연산자인데 앞에 이미 false이므로 의미 없어서 뒤에는 실행하지 않는다
		System.out.println(false && true); //false
		System.out.println(false && false); //false
		
		
		System.out.println (true || true); //true //or 은 뒤에 dead code라고 뜬다
		System.out.println( false|| true); //true
		System.out.println( true || false); //true
		System.out.println(false || false); //false
		return false;
		
		
	}
	
	//5. 비교 연산자
	public static void opr05() {
		
		System.out.println(1==2); //false
		System.out.println(1>=2); //false
		System.out.println(1>2); //false
		System.out.println(1<2); //true
		System.out.println(1!=2); //true
	}
	
	
	//6. 삼항 연산자
	//(조건) ? 참일 때 리턴값: 거짓일 때 리턴값;
	//참일 때 리턴값과 거짓일 때 리턴값은 타입이 같아야한다
	public static boolean opr06() {
		
		int a = 13;
		int res = (TEN > a) ? TEN : a;
		System.out.println(res);
	
		String result = (TEN > a) ? "TEN이 더 큽니다." : "a가 더 큽니다.";
		System.out.println(result);
		
		int b=15;
		
		int val = (a > b) ? a:((a < b) ? b:a);
		System.out.println(val);
		
		return false;
		
	}
	
	// 7. 비트 연산자 : & , | , ~, ^, <<, >>
	//값을 0, 1 비트 상태에서 연산한 결과
	public static void opr07() {
		
		int a=10;
		//0000 0000 0000 0000 0000 0000 0000 1010;(4byte/32bit)
		
		int b=2;
		//0000 0000 0000 0000 0000 0000 0000 0010;
		
		System.out.println("a & b" + (a & b));
																							
		//0000 0000 0000 0000 0000 0000 0000 1010;
		//0000 0000 0000 0000 0000 0000 0000 0010;
		//&---------------------------------------
		//0000 0000 0000 0000 0000 0000 0000 0010;
		
		System.out.println("a | b = " + (a|b) );
		//0000 0000 0000 0000 0000 0000 0000 1010;
		//0000 0000 0000 0000 0000 0000 0000 0010;
		//|---------------------------------------
		//0000 0000 0000 0000 0000 0000 0000 1010;
		
		System.out.println(~a);
		//0000 0000 0000 0000 0000 0000 0000 1010;
		//1111 1111 1111 1111 1111 1111 1111 0101;
		
		
		int c=10;
		System.out.println(c>>2);
		//2진수로 출력하고자 한다면 Integer class를 이용함
		System.out.println(Integer.toBinaryString(c>>2) + "(2)");
		// 00 0000 0000 0000 0000 0000 0000 0000 0000 10; /10 -> 2
	
		System.out.println(c<<4);
		   // 0000 0000 0000 0000 0000 0000 0000 1010;
		//  0000 0000 0000 0000 0000 0000 1010 0000; -> 160 
		
		System.out.println(c>>1);
		
		//0 0000 0000 0000 0000 0000 0000 0000 101;
		
		
		

		
		
		
		
	}
	
	
}
