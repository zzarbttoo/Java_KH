package com.bbb;

//AAA를 import해서 걔를 extends 했다 (상속)
//ctrl + shift + s -> 저장 -> 저장하면 자동으로 compile 된다
import com.aaa.AAA;

public class BBB extends AAA {

	//부모의 기본 생성자를 지우면 에러가 생긴다
	
	//부모의 생성자를 모두 지우면 에러가 안난다 -> 생성자를 만들지 않으면, 알아서 자바 가상 머신이 생성자를 만들어준다
	private int b;
	public BBB() {
//		super(); //부모 생성자 호출(아무것도 적어주지 않으면) -> 자동으로 생성해준다 
		System.out.println("BBB생성 (기본 생성자)");
	}
	
	//부모의 기본 생성자를 지우면 에러가 생긴다 
	//부모의 생성자를 모두 지우면 에러가 안난다
	public BBB(int b) {
		this.b = b;
		System.out.println("BBB 생성(파라미터 b 받아서 초기화, 생성)");
	}
	
	public BBB(int abc, int b) {
		super(abc);
		this.b = b;
		System.out.println("BBB 생성(abc, b 받아서 초기화 및 생성)");
	}
	
	public int getB() {
		return this.b;
	}
	
	public void setB(int b) {
		this.b = b;
		
	}
	
	public int getSum() {
		return super.getAbc() + this.getB();
		//super:부모객체, this:나 객체
		// getAbc() + getB == super.getAbc() + getB
		
	}
	
	
	@Override //재정의 : 부모의 메소드를 확장시켜 사용할 수 있다(단, 부모 메소드와 똑같이 생겨야한다)
	public void prn() {
		System.out.println("BBB.prn()");
	}
	
	
	
	
	
	
}
