package com.test01;

import java.util.Arrays;

public class MTest03 {

	// 1. a ~ z 까지의 값을 가지는 1차원 배열을 만들자
	// 2. 위에서 만든 배열을
	/*
	 * a b c d e f g h i ...
	 * 
	 * 
	 * y z 형태로 출력하자
	 * 
	 * 
	 */
	// 3. 거꾸로 출력하자
	// 4. 대문자 출력

	/*
	 * 5. 147 258 369
	 * 
	 * 6. 12345 109876 11121131415 2019181716
	 * 
	 * 
	 */

	public static void main(String[] args) {

		int[][] tempo1 = new int[3][3];

		int[][] tempo2 = new int[4][5];
		

		int t = 0;
		int t2= 0;
		
		for (int i = 0; i < tempo1.length; i++) {
			for (int j = 0; j < tempo1[i].length; j++) {

				t++;
				tempo1[i][j] = t;

			}
		}
		
		for(int i = 0; i < tempo2.length; i++) {
			for(int j = 0; j < tempo2[i].length; j++) {
				
				t2++;
				tempo2[i][j] = t2;
			}
		}
		
		System.out.println(Arrays.deepToString(tempo2));

//		char alpha[] = new char[26];
//		for (int r = 0; r < alpha.length; r++) {
//			alpha[r] = (char) ('a' + r);
//		}
//
//		prn(alpha);
//		System.out.println();
//		
//		reversePrn(alpha);
//		System.out.println();
//		
//		upperPrn(alpha);
//		System.out.println();
//		
		temp1(tempo1);
		System.out.println();
		
		temp2(tempo2);
		System.out.println();
	}

	private static void prn(char[] ch) {

		for (int i = 1; i <= ch.length; i++) {
			System.out.print(ch[i - 1] + " ");

			if (i % 6 == 0) {
				System.out.println();
			}
		}

//		for (int p = 0; p < ch.length; p++) {
//
//			System.out.printf("%2c", ch[p]);
//			if ((p + 1) % 6 == 0) {
//
//				System.out.println();
//			}
//		}

		System.out.println("\n");
	}

	private static void reversePrn(char[] ch) {

		int temp = 1;

//		for (int j = ch.length - 1; j >= 0; j--) {
//			System.out.printf("%2c", ch[j]);
//			if ((ch.length - j) % 6 == 0) {
//				System.out.println();
//			}
//		}

		for (int i = ch.length; i > 0; i--) {
			System.out.print(ch[i - 1] + " ");

			if (temp % 6 == 0) {
				System.out.println("");
			}

			temp++;
		}
		System.out.println("\n");

	}

	private static void upperPrn(char[] ch) {
		for (int k = 0; k < ch.length; k++) {

			System.out.printf("%2c", Character.toUpperCase(ch[k]));
			if ((k + 1) % 6 == 0) {
				System.out.println();
			}

		}
	}

	private static void temp1(int[][] tempo1) {

		for (int i = 0; i < tempo1.length; i++) {
			for (int j = 0; j < tempo1[i].length; j++) {

				System.out.printf("%2d", tempo1[j][i]);

			}
			System.out.println();
		}

		System.out.println("\n");

	}

	private static void temp2(int[][] tempo2) {

		for (int i = 0; i < tempo2.length; i++) {

			if (i % 2 == 1) {

				for (int j = tempo2[i].length - 1; j >= 0; j--) {
					System.out.printf("%3d", tempo2[i][j]);
				}

			} else {

				for (int j = 0; j < tempo2[i].length; j++) {
					System.out.printf("%3d", tempo2[i][j]);
				}

			}
			System.out.println();
		}

	}
}