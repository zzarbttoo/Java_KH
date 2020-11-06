package com.test01;

public class MTest {

	public static void main(String[] args) {
		
		//AA라는 객체가 Super라는 값의 모양도 가질 수 있다(다형성)
		AA a = new AA();
		Super s = a;
		
		//부모타입이 더 큰 값이라 부모타입을 자식타입으로 넣어줄 때 명시적 형변환을 해보았다(compile error은 안난다)
		//그러나 실행을 했을 때, 둘이 다른 객체임을 알아 에러가 난다(런타임 에러)
		BB b = (BB) s;
		
		//부모타입에 있는 것을 자식 타입에 형변환하여 담을 수 있다
		AA b1 = (AA) s;
		
		
	}
}
