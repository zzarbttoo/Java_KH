package com.test02;

import java.util.StringTokenizer;


//문자열을 자르는 방법들 
public class MTest02 {

	public static void main(String[] args) {

		String str = "The, String, class, represents";

		// 1.

		System.out.println(str.substring(4, 10));

		// 2.
		// 원래는 regex가 들어간다(하지만 문자열로도 표현 가능)
		String[] splitArr = str.split(",");

		for (int i = 0; i < splitArr.length; i++) {
			System.out.println(splitArr[i]);
		}

		String str2 = "The_String_class_represents";

		// java.util에 있다
		StringTokenizer st = new StringTokenizer(str2, "_");

		
		//hasMoerElements 는 object 객체로 들어가있다
		//hasMoreToken 은 string 객체로 들어간다 
		//커서가 값을 가르키며, 값을 계속해서 잘라준다(다음 값이 없을 때 까지 커서가 이동한다)
		//커서는 값이 저장되어 있는 위치를 알려준다 
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
	}
}
