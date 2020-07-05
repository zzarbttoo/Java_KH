package com.test03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.compare.Score;

public class MTest02 {

	public static void main(String[] args) {
		Score score1 = new Score("홍길동", 99, 90, 89);
		Score score2 = new Score("이순신", 100, 65, 85);
		Score score3 = new Score("김선달", 68, 100, 77);
		
		Set<Score> set = new HashSet<Score>();
		set.add(score1);
		set.add(score2);
		set.add(score3);
		
		printSet(set);
		
		//세번째 학생을 찾아서 국어점수를 0으로 바꾸자
		transElement(set);
		printSet(set);
		
	}
	private static void transElement(Set<Score> set) {
		
//		
//		int now = 0;
//		
//		Iterator<Score> ir = set.iterator();
//		
//		while(ir.hasNext()) {
//			
//			now ++;
//			if(now == 3) {
//				
//				ir.next().setKor(0);
//				break;
//				
//			}else {
//				
//				ir.next();
//			}
//			
//			
//			
//		}
		
	
		
		Iterator<Score> ir = set.iterator();
		
		
			while(ir.hasNext()) {
				
				//iterator 안에 Score이 있다
				Score temp=ir.next();
				
				if(temp.getName().equals("김선달")) {
					
					temp.setKor(0);
				}
				
				
		
				
			
				
			}
		
	}
	//Set에서 값 가져오는 방법
	private static void printSet(Set<Score> set) {
		
		//1.
		/*
		 * for(Score s: set) {
			System.out.println(s);
		}
		
		*/
		
		//2. set안의 값들을 Object 객체로 리턴해준다
		
		/*
		Object[] arr = set.toArray();
		for(int i= 0; i <arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		*/
		
		//3. ★Iterator : 컬렉션 저장 요소를 읽어오는 표준화 된 방법
		Iterator<Score> ir = set.iterator();
		
		while(ir.hasNext()) {
			
			System.out.println(ir.next());
			
		}
		
		
		
		
		
		
		
	}
	
	
}
				
				
