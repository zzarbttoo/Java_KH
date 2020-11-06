package com.test03;

//extends : class - class (interface - interface)
// implements : 자식 class - 부모 interface
public class Cat implements Animal {

	@Override
	public void bark() {

		System.out.println("야옹");
		
	}

	@Override
	public void eat(String feed) {

		System.out.println("고양이가" + feed + "먹는다");
	}

}
