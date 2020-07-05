package com.test05;

import java.util.Scanner;

public class Triangle extends AreaImpl{

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변을 입력해주세요");
		Double flow = sc.nextDouble();
		System.out.println("높이를 입력해주세요");
		Double height = sc.nextDouble();
		
		String result = Double.toString(flow * height /2 );
		
		super.setResult(result);
			
	}

	@Override
	public void print() {
		System.out.println("삼각형의");
		super.print();
	}

	
	

}
