package com.test01;

public class MethodTest01{
	//class: 설계도  : 기능(method), 속성
	//접근지정자 메모리영역 리턴타입 메소드 이름(파라미터) { 명령;..}

	public static void main(String[] args) {
		//static method를 호출하는 방법: Class.method();
		//.은 참조 연산자
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		//같은 class 내부에 있으면 class 이름 생략 가능
		defaultMethod();
		privateMethod();
		
		//nonstatic method 호출 방법
		// type 변수= new type()  class 변수= new class();
		//변수.method();				변수.method();
		MethodTest01 method01=new MethodTest01();
		method01.nonStaticMethod();
		
		// UML : Unified Modeling Language
		// http://www.objectaid.com
	
	}
	
	//접근 제한자: 메소드를 호출할 수 있는 범위를 알려준다.
	//public
	public static void publicMethod() {
		System.out.println("public method");
		System.out.println("->어디서나 접근, 참조 가능(+)");
	}
	
	//protected
	protected static void protectedMethod() {
		System.out.println("protected method");
		System.out.println("->상속일 경우, 상속된 곳에서(#)");
		System.out.println("->상속이 아닐 경우 , 같은 패키지 내에서");
	}
	
	//default
	static void defaultMethod() {
		System.out.println("default method");
		System.out.println("-> 같은 패키지 내에서 (~)");
	}
	
	//private
	private static void privateMethod() {
		System.out.println("private method");
		System.out.println("->현재 클래스 내에서만(~)");
	}
	
	//메모리 영역 
	// non-static

	public void nonStaticMethod() {
		System.out.println("non static method");
		System.out.println("객체를 만들어서 호출");
		
	
	}
}
