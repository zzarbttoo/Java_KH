package com.test02;

import java.util.Arrays;

public class MTest01 {

	public static void main(String[] args) {
		
		//originalArr의 주솟값을 copyArr 값으로 넣어라 -> 즉 두 배열은 같다
		//Shallow Copy : 얕은 값 복사 (주소 값 복사)
		int[] originalArr = {10, 20, 30};
		int[] copyArr = originalArr;
		
		System.out.println(Arrays.toString(originalArr));
		System.out.println(Arrays.toString(copyArr));
		
		System.out.println(originalArr == copyArr);
		
		copyArr[1] = 100;
		System.out.println(Arrays.toString(originalArr));
		System.out.println(Arrays.toString(copyArr));
		
		//hashcode : 주소 
		//같은 주솟값이 나오는 것을 확인할 수 있다
		System.out.println(originalArr.hashCode());
		System.out.println(copyArr.hashCode());
	}
	
}
