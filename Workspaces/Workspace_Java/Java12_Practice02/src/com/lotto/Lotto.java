package com.lotto;

import java.util.Arrays;
import java.util.Random;

/* 1~45까지의 중복되지 않는 숫자 6개
 * -> 작은 수부터 나오도록 정렬
 */

public class Lotto {

	public static void main(String[] args) {

//		lotto();
	}

	private int[] make() {

		int[] arr = new int[6];
		int index = 0;

		// 6개의 랜덤 값을 가지고 index가 만들어진다
		while (index < 6) {

			int insert = (int) (Math.random() * 45) + 1;
			System.out.println(Arrays.toString(arr));
			System.out.println("->" + insert + "\n");
			
			// 배열 안에 같은 값이 없을 때 인덱스로 추가
			if (!isSame(arr, insert)) {
				arr[index] = insert;
				index++;
			}
		}

		return arr;
	}

	// true로 return 할 경우 배열 내에 같은 값이 존재
	private boolean isSame(int[] arr, int insert) {

		boolean same = false;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == insert) {
				same = true;
			}
		}

		return same;
	}

	private void sort(int[] arr) {

		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length; j++) {
				
				if(arr[j] < arr[j-1] ) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
		
		
	}

	public void prn() {

		int[] arr = make();
		sort(arr);
		
		for(int i =0; i< arr.length; i++) {
			
			System.out.print(arr[i] + " ");
				
			}
		}
		
		

//	private static void lotto() {
//
//		int[] lottoL = new int[6];
//		int rand = 0;
//		int sum = 0;
//
//		lottoL[0] = (int) (Math.random() * 44) + 1;
//
//		for (int i = 0; i < lottoL.length; i++) {
//
//			sum = 0;
//
//			while (true) {
//
//				sum++;
//				rand = (int) (Math.random() * 44) + 1;
//				if (rand != lottoL[sum]) {
//
//					lottoL[i] = rand;
//					break;
//				}
//			}
//		}
//
//		System.out.println(Arrays.toString(lottoL));
//
//		int temp = 0;
//
//		for (int i = 0; i < lottoL.length; i++) {
//
//			for (int j = i + 1; j < lottoL.length; j++) {
//
//				if (lottoL[i] > lottoL[j]) {
//
//					temp = lottoL[i];
//					lottoL[i] = lottoL[j];
//					lottoL[j] = temp;
//
//				}
//
//			}
//		}
//		System.out.println(Arrays.toString(lottoL));
//
//	}

}
