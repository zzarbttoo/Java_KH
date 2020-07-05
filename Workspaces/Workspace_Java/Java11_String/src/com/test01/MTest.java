package com.test01;

public class MTest {

	static String str = "The String class represents character strings.";

	public static void main(String[] args) {

		String s = "hello";
		// 숫자 -> string 이 나와서 계산이 됨
		System.out.println(1 + 2 + s);
		System.out.println(s);
		// string -> 숫자이기 때문에 string으로 인식
		System.out.println(s + 1 + 2);

		// 대입하면 값은 변하지 않지만 주솟값은 변한다(immutable)
		s = 1 + 2 + s;
		s = s + 1 + 2 + "!";
		System.out.println(s);

		// 1. str의 길이
		test01();
		// 2. str 전체 대문자로 바꾸자(바꾸어 출력)
		test02();
		// 3. str 전체 소문자로 바꾸자(바꾸어 출력)
		test03();
		// 4. str에서 첫번째 c의 인덱스 위치
		test04();
		// 5. 'class'를 'java'로 바꿔서 전체 출력
		test05();
		// 6. 'character'를 찾아서 대문자로 변환 후 전체 출력
		test06();
		// 7. str을 char[]로 출력하되, 'c'만 출력
		// 그리고 c의 갯수 출력
		test07();
		// 8. str을 char[] 로 출력하되, 대문자만 출력
		// 그리고 대문자의 갯수 출력
		test08();
		// 9. 모든 공백 제거 후 출력
		test09();
		// 10. 역순 출력
		test10();

	}

	private static void test01() {

		System.out.println(str.length());
	}

	private static void test02() {
		System.out.println(str.toUpperCase());
	}

	private static void test03() {
		System.out.println(str.toLowerCase());
	}

	private static void test04() {
		System.out.println(str.indexOf("c"));
	}

	private static void test05() {
		System.out.println(str.replace("class", "java"));

	}

	// substring
	private static void test06() {
		System.out.println(str.replace("character", str.valueOf("character").toUpperCase()));
//		String target = " cahracter";
//		int startIdx = str.indexOf(target);
//		int endIdx = startIdx + target.length();
//		String upperTarget = str.substring(startIdx, endIdx).toUpperCase();
//		System.out.println(str.replace(target, upperTarget));
	}

	private static void test07() {

//		int sum = 0;
//
//		for (int i = 0; i < str.length(); i++) {
//			if (str.toCharArray()[i] == 'c') {
//				System.out.print('c');
//				sum++;
//
//			}
//		}
//		System.out.println(sum);

		char[] arr = str.toCharArray();

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

//			if(arr[i] == 'c' || arr[i]) {
			if (Character.toLowerCase(arr[i]) == 'c') {
				System.out.print(arr[i]);

				count++;
			}
		}
		System.out.println();
		System.out.println(count);

	}

	private static void test08() {

//		int sum = 0;
//
//		for (int i = 0; i < str.length(); i++) {
//			if (Character.isUpperCase(str.toCharArray()[i]) && Character.isLetter(str.toCharArray()[i])) {
//				System.out.print(str.toCharArray()[i]);
//				sum++;
//			}
//		}
//		System.out.println();
//		System.out.println(sum);

		char[] arr = str.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			// 아스키코드로 풀수도 있다 !!!!!!
			if (Character.isUpperCase(arr[i])) {
				System.out.print(arr[i]);
				count++;
			}
		}
		System.out.println(count);
	}

	private static void test09() {
//trim() 은 앞뒤 공백 제거 -> 전체 공백을 제거할 수 없다 
		
		
//		System.out.println(str.replace(" ", ""));
//		System.out.println(str.replaceAll(" ", ""));
//		System.out.println(str.replaceFirst(" ", ""));
		

		
	}

	private static void test10() {

//		for (int i = str.length() - 1; i >= 0; i--) {
//			System.out.print(str.toCharArray()[i]);
//		}
		
		for(int i = str.length(); i > 0; i--) {
			//해당 index에 있는 character 값 하나를 return 해준다
			System.out.print(str.charAt(i-1));
		}
	}

}
