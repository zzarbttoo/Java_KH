package com.test05;

import java.util.Scanner;

public class Square extends AreaImpl{

	@Override
	public void make() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변을 입력해주세요");
		Double flow = sc.nextDouble();
		System.out.println("높이를 입력해주세요");
		Double height = sc.nextDouble();
		
		String result = Double.toString(flow * height);
		super.setResult(result);
		
		
	}

	@Override
	public void print() {
		System.out.print("사각형의");
		super.print();
	}



}
