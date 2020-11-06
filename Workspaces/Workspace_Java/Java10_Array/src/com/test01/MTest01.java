package com.test01;

import java.util.Arrays;

public class MTest01 {

	public static void main(String[] args) {
		// 방법 1
		int[] a; // 선언
		a = new int[5]; // 정의

		a[0] = 1; // 초기화
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;

		// 방법2
		int[] b = new int[] { 6, 7, 8, 9, 10 }; //선언 정의 초기화
		
		//방법3
		int[] c = {5, 4, 3, 2, 1}; // 선언 초기화 
		
		System.out.println(a[1]);
		System.out.println(b[3]);
		//c라는 배열이 저장돼있는 주솟값이 출력됐다 -> 배열은 참조타입(객체)이다
		System.out.println(c);
		prn(c);
		//배열과 관련된 class인 Arrays
		System.out.println(Arrays.toString(c));
		
		String[] q = new String[] {"have" , "a" , "nice", "day"};
		modi(q);

	}
	
	public static void prn(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d", arr[i]);
			
		}
		
	}
	
	public static void modi(String[] test) {
		
//		test[2] = "good";
		
		for(int i = 0; i<test.length; i++) {
			
			if(test[i] == "nice") {
				test[i] = "good";
			}
			System.out.print(test[i] + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(test));
		
		
	}
}
