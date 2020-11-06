package com.test05;

import java.util.Scanner;

public class Circle extends AreaImpl{

	@Override
	public void make() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력해주세요");
		int r = sc.nextInt();
		
		//super.setResult(String.valueOf(Maht.~~));
		//super.setResult(Math.~~ + "") <- String competination 문자열로 바뀐다!!!<외워>
		String result = Double.toString(Math.pow(r, 2) * Math.PI);
		super.setResult(result);
		
		
		
		
	}

	@Override
	public void print() {
		System.out.print("원의");
		super.print();
	}


	

	
}
