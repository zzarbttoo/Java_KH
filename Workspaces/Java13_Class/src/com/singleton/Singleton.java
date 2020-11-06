package com.singleton;

//메모리(Heap)에 객체를 한번만 생성하겠다

public class Singleton {

	//2. 객체를 확인할 주소(reference)값 저장할 필드
	//singleton type이 만들어져있는지 아닌지 확인하기 위해 Singleton type으로 만들었다
	private static Singleton singleton;
	
	// 1. 생성자를 private으로 만든다(외부에서 생성 불가)
	private Singleton() {
		
		System.out.println("singleton instance 생성");
		
	}
	
	//3. 객체 생성 메서드 
	public static Singleton getInstance() {
		
		//만일 heap 영역에 객체가 없으면 객체 생성
		if(singleton == null) {
			
			singleton = new Singleton();
			
		}
		
		//singleton 객체의 주소값
		return singleton;
		
	}
	
	
	
	
	
}
