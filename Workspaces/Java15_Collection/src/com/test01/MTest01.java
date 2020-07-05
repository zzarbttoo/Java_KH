package com.test01;

import java.util.Vector;

public class MTest01 {

	// Vector(Class) 
	
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer> (10, 5);
		
		System.out.println(v.size() + " : " + v.capacity());
		v.add(1);
		//size는 v 안에 몇개가 들어가있냐, capacity는 최대 용량을 말한다
		System.out.println(v.size() + " : " + v.capacity());
		
		//객체를 넣으면 원래 주솟값이 나오는데, vector은 내부의 값이 나왔다
		//이 객체 안에는 toString() 이 override 돼있겠구나 생각하자!
		System.out.println(v);
		
		for(int i = 2; i<10; i++) {
			v.add(i);
		}
		
		// 10칸
		System.out.println(v.size() + " : " + v.capacity());
		System.out.println(v);
		v.add(10);
		System.out.println(v);
		
		//초과할 경우, 5칸씩 더 생성이 된다(최대용량 5만큼 증가)
		v.add(11);
		System.out.println(v.size() + " : " + v.capacity());
		System.out.println(v);
		
	}
	
	
}
