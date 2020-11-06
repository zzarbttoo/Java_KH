package com.test02;

import java.util.ArrayList;
import java.util.List;

public class MTest01 {

	public static void main(String[] args) {
		// List 가 부모, ArrayList가 자식
		List<String> list = new ArrayList<String>();

		list.add("홍길동");
		list.add("이순신");
		list.add("김선달");
		list.add("조세호");
		list.add("강호동");
		list.add("유재석");
		list.add("신동엽");
		list.add("조세호");

		System.out.println(list);
		prn(list);
		transElement(list);
		prn(list);
	}

	private static void transElement(List<String> list) {

		// 1. 홍길동을 김길동으로
		// 2. ~신으로 끝나는 객체를 ~자로
		// 3. 끝 글자가 호면 이름 삭제

		list.set(list.indexOf("홍길동"), "김길동");

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).endsWith("신")) {

				list.set(i, list.get(i).replace("신", "자"));
			}
			
			if(list.get(i).endsWith("호")) {
			
				//Object를 넣어서 삭제할 수도 있따 
				list.remove(i);
			
			}
		}
		
		

	}

	// {d , d, d}
	private static void prn(List<String> list) {

		System.out.print("{");
		for (int i = 0; i < list.size(); i++) {

			System.out.print(list.get(i));
			if (i != list.size() - 1) {
				System.out.print(",\t");
			}
			

		}
		System.out.print("}");
		System.out.println();
	}

}
