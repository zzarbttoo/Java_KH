package com.test01;

import java.util.Arrays;

public class MTest02 {

	public static void main(String[] args) {
		// 방법 1
		int[][] a = new int[3][2];

		a[0][0] = 1;
		a[0][1] = 2;
		a[1][0] = 3;
		a[1][1] = 4;
		a[2][0] = 5;
		a[2][1] = 6;

		// 방법 2 작은 배열의 크기는 꼭 같지 않아도 된다
		int[][] b = new int[3][];
		b[0] = new int[3];
		b[1] = new int[5];
		b[2] = new int[2];

		// 방법 3
		int[][] c = new int[][] { { 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 } };

		// 방법 4
		int[][] d = { { 1, 2, 3, 4 }, { 5 }, { 6, 7 }, { 8, 9, 10 } };
		prn(d);
		
		//해당 배열 값 출력(그냥 Arrays.ToString 쓰면 배열 주솟값 출력 (2차원 배열))
		//다차원 배열은 Arrays.deepToString()을 써야한다
		System.out.println(Arrays.deepToString(d));
		
		String[][] s= {
				{"Have" , "a" , "Good", "Day"}, 
				{"너무", "어려워"},
				{"이차원", "배열"}
		};
		
		test(s);
		
	}

	/*
	 * 1 2 3 4 5 6 7 8 9 10
	 */

	public static void prn(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			//arr[i] 를 입력할 경우 ArrayIndexOutofBoundsException이 발생한다 
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void test(String[][] arr) {
		
		//Good -> Nice
		//어려워 -> 쉬워
		//전체 출력
//		String[][] s= {
//				{"Have" , "a" , "Good", "Day"}, 
//				{"너무", "어려워"},
//				{"이차원", "배열"}
//		};
		
		arr[0][2] = "Nice";
		arr[1][1] = "쉬워";
		
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	}
}
