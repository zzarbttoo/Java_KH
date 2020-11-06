package com.test01;

import java.util.Vector;

public class MTest02 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("홍길동");
		v.add("이순신");
		v.add("김선달");
		v.add("강호동");
		v.add("유재석");
		v.add("신동엽");
		v.add("조세호");

		prn(v);
		transElement(v);

		prn(v);

	}

	// 1. 홍길동의 인덱스를 찾아서, vector 값을 홍길순으로 바꾸자
	// 2. "~신" 으로 끝나는 객체를 찾아서,
	// 만일 있다면, "신" 을 "자" 로 바꾸자
	// 3. 마지막 글자가 "호" 인 이름을 찾아서,
	// 만일 있다면 삭제하자
	private static void transElement(Vector<String> v) {

//		for(String s:v) {
//			
//			if ( s.equals("홍길동")) {
//				v.set(v.indexOf(s), "홍길순");
//			}
//			if (s.endsWith("신")) {
//				v.set(v.indexOf(s), s.replace("신", "자"));
//			}
//			if(s.endsWith("호")) {
//				v.remove(v.indexOf(s));
//			}
//		}
//		

		// 1
		v.set(v.indexOf("홍길동"), "홍길순");
		System.out.println(v);

		// 2 set이 있다면 get도 있다
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).endsWith("신")) {

				v.set(i, v.get(i).replace("신", "자"));
			}
		}

		// 3
	
		//ConcurrentModificaiton Exception이 발생함 
		//동시에 수정이 불가하다 (for/each 문에서) <- 다른 것이 동시적으로 접속하면 안된다
		//반복문이 접근한 상태인데, 어떤 것이 접근해서 뺐어가면 안된다
		//		for(String s : v) {
		//			if(s.endsWith("호")) {
		//				v.remove(s);
		//			}
		//		}
		
		
		for(int i= 0; i<v.size(); i++) {
			
			if(v.get(i).endsWith("호")) {
				v.remove(v.get(i));
			}
			
			System.out.println(v);
		}

	}

	private static void prn(Vector<String> v) {

		System.out.print("{");

		// Vector 은 이렇게 명령어를 써서 출력 가능하다
		// for (덩어리 안의 변수): Collection(덩어리)
		// 덩어리에서 value가 나와서 s에 값이 저장되게 된다

		// collection 안의 처음부터 전체를 순회할 것이다
		for (String s : v) {

			System.out.println(s + "\t");

		}
		System.out.println("}");

	}

}
