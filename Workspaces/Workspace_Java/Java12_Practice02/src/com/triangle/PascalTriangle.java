package com.triangle;

import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("input n:");
		int n = sc.nextInt();
		
		int[][] arr = new int[n][];
		arr[0] = new int[] {1};
		
		for(int i = 1; i < arr.length; i++) {
			
			arr[i] = new int[i+1];
			
			for(int j = 0; j < arr[i].length ; j++) {
				
				if(j == 0|| j == arr[i].length - 1) {
					arr[i][j] = 1;
				}else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
				
			}
		}
		
		
//		triangle();
		triangleT(arr);

	}

	private static void triangleT(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr.length; j > i; j-- ) {
				System.out.print("  ");
			}
			
			for(int k = 0; k < arr[i].length; k++) {
				System.out.printf("%4d", arr[i][k]);
			}
			System.out.println();
		}
		
		
	}

	private static void triangle() {

//		int[][] pas = new int[7][7];
//
//		for (int i = 0; i < 7; i++) {
//
//			for (int k = 7-i; k > 0; k--) {
//				System.out.print(" ");
//			}
//			
//			for (int j = 0; j < 7; j++) {
//
//				if (j == 0 || j == i) {
//					pas[i][j] = 1;
//					System.out.printf("%3d", pas[i][j]);
//
//				} else if (j < i) {
//
//					pas[i][j] = pas[i - 1][j - 1] + pas[i - 1][j];
//					System.out.printf("%3d", pas[i][j]);
//
//				}
//
//			}
//			System.out.println();
//
//		}
		
		
		
	}
}
