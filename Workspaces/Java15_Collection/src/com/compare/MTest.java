package com.compare;

import java.util.Arrays;

public class MTest {

	
	public static void main(String[] args) {
		//Score type의 값 3개를 저장할 수 있는
		//Student 라는 배열을 만들고, 자기 자신과 양쪽 짝궁 객체를 만들어서
		//해당 배열에 저장하자
		
		
		Score[] student = new Score[3];
		student[0] = new Score("조용승", 100, 60, 100);
		student[1] = new Score("배유진", 70, 80, 90);
		student[2] = new Score("김지훈", 100, 90, 100);
		
		for(Score score:student) {
			
			System.out.println(score);
			
		}
		
		//
		Arrays.sort(student);
		System.out.println(student);
		
		for(Score score : student) {
			System.out.println(score);
		}
		
		//정렬
		int[] arr = {1, 4, 2, 3, 5};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
	
}
