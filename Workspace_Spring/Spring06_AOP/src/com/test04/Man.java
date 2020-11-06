package com.test04;

public class Man implements Person{

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 축구 본다");
		//nullpointerException 발생
		String s = null;
		s.charAt(0);
		return "재밌다";
	}

}
