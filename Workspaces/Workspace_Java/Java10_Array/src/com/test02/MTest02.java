package com.test02;

import java.util.Arrays;

public class MTest02 {

	
	//Deep Copy : 값 자체를 복사해서 새로운 배열 생성 
	public static void main(String[] args) {
		
		int[] originalArr = {10, 20, 30, 40};
		
		//1. 배열 인덱스의 값을 복사
		int[] copyOne = new int[originalArr.length];
		
		for(int i = 0; i < copyOne.length; i++) {
			copyOne[i] = originalArr[i];
			
		}
		System.out.println(Arrays.toString(originalArr));
		System.out.println(Arrays.toString(copyOne));
		System.out.println(originalArr == copyOne);
	
		copyOne[1] = 100; 
		System.out.println(Arrays.toString(copyOne));
		System.out.println(Arrays.toString(originalArr));
		
		//2. 원본 배열에게 요청
		//false가 출력되는 것을 보니 둘은 다른 배열이다
		int[] copyTwo = originalArr.clone();
		System.out.println(Arrays.toString(originalArr));
		System.out.println(Arrays.toString(copyTwo));
		System.out.println(originalArr == copyTwo);
		
		copyTwo[1] = 100;
		System.out.println(Arrays.toString(originalArr));
		System.out.println(Arrays.toString(copyTwo));
		
		//3. System을 사용하여 복사 
		//fill method는 해당 배열의 값을 내가 원하는 값으로 바꿔준다
		int[] systemArray = new int[10];
		Arrays.fill(systemArray, 7);
		System.out.println(Arrays.toString(systemArray));
		
		//System.arrayCopy(원본 배열 객체, 원본 시작 위치, 복사 배열 객체, 복사 시작 위치, 복사할 갯수)
		System.arraycopy(originalArr,1,systemArray, 3, 2);
		System.out.println(Arrays.toString(systemArray));
		
		
		//주솟값이 다 다른 것을 확인할 수 있다
		System.out.println("---------------");
		System.out.println(originalArr.hashCode());
		System.out.println(copyOne.hashCode());
		System.out.println(copyTwo.hashCode());
		System.out.println(systemArray.hashCode());
	}
}

		
		