package com.aaa;

//해당 메소드, 클래스는 어떤 일을 하는지 바로 알아들을 수 있도록 만드는 것이 중요하다
//object를 상속받은 AAA
public class AAA {

	// field(속성)
	private int abc; // 인스턴스 변수(static이 안붙음) //static이 붙으면 class 변수

	// constructor (생성자): 접근 제한자 + class 이름 (parameter가 없는 거을 기본 생성자라고 한다)
	public AAA() {
		System.out.println("AAA 생성(기본 생성자)");
	}

	// 파라미터 한개짜리 생성자
	public AAA(int abc) {

		this.abc = abc;
		System.out.println("AAA 생성(파라미터 abc 받아서 초기화하면서 생성)");
	}

	// getter & setter

	// getter
	public int getAbc() {
		return this.abc;
	}

	// setter
	public void setAbc(int abc) {
		this.abc = abc;
	}

	// method(기능)
	public void prn() {
		System.out.println("AAA의 prn 메소드");

	}

}

/*
 * 
 * 
 * <생성자>
 * 1. 클래스 이름과 동일하되, 리턴 타입 없고, 객체 생성시 접근 제한자는 public
 * 
 * class Test{
 * 
 * 	public Test(){
 * }
 * 
 * }
 * 
 * 
 * 2. 생성자는 객체 생성을 하는 new 연산자와 함께 사용하며
 * 생성시 단 한번만 자동 호출된다 
 * 
 * Test t1 = new Test();
 * 
 * 3. 메서드처럼 객체 및 클래스 명으로 호출할 수 없다
 * t1.Test(); // 안됨!!!!!!!
 * 
 * 4. overload 할 수 있다 : 파라미터 타입을 다르게 생성자 타입을 여러개로 만들 수 있다 
 * class Test{
 * 
 * public Test(){}
 * public Test(int a){}
 * public Test(int a, int b){}
 * }
 * 
 * 5. 생성자를 명시하지 않으면, 기본 생성자가 제공되어 필드 초기화 하고,
 * 명시된 생성자를 선언하게 되면 명시 생성자만 호출되고 기본 생성자는 자동 생성되지 않는다
 *
 *class AA{   //new AA();
 *}
 *
 *class BB{ //new BB(); 안됨
 *	public BB(int b){}// // new BB(10); 됨!
 *}
 *
 * 
 * 7. 생성자는 내부 호출 가능하며, 키워드는 this();
 * 
 * 8. 생성자의 목적은 필드 초기화 및 객체 생성에 있다
 * 
 *  
 * 
 * 
 * 
 * 
 */