package com.test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//public class기 때문에 공식 class 이므로 이 클래스 이름은 MTest02 class
//public class는 하나만 있어야한다
public class MTest02 {

	
	public static void main(String[] args) {
		List <String> list = new ArrayList<String>();
		
		for(int i = 1; i < 11; i++) {
			//숫자를 String type으로 받는다
			list.add(String.valueOf(i));
		}
		
		System.out.println(list);
		Collections.sort(list);
		
		//문자열이기 때문에 1, 10, 2, ... 이렇게 나온다
		System.out.println(list);
		
		//comperator 객체를 넣어줬다
		Collections.sort(list, new MySortTest());
		System.out.println(list);
		
	}
}

//default class : 여기서 잠깐 사용할 때 쓰긴 한다
//그러나 별로 좋지는 않다
//class MySortTest implements Comparator<String>{
//
//	@Override
//	public int compare(String o1, String o2) {
//		
//		/*
//		 * 1이면 앞의 인자가 더 큰 값
//		 * 0이면 같은 값
//		 * -1이면 뒤의 인자가 더 큰 값
//		 */
//		
//		//변수명을 other 1, other 2 처럼 알아볼 수 있게 쓰는 것이 좋다
//		int tmp1 = Integer.parseInt(o1);
//		int tmp2 = Integer.parseInt(o2);
//		
//		if(tmp1 > tmp2) {
//			return -1;
//		}else if(tmp1 < tmp2) {
//			return 1;
//		}
//		return 0;
//	}
//	
//	
//}

class MySortTest implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		
		int tmp1 = Integer.parseInt((String) o1);
		int tmp2 = Integer.parseInt((String) o2);
		
		if(tmp1 > tmp2) {
			return -1;
		}else if(tmp1 < tmp2) {
			return 1;
		}
		return 0;
	}

	
		
		
		
	
	
}
