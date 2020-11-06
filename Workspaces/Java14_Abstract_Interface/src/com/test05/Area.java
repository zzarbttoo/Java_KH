package com.test05;

public interface Area {
	//변수는 상수화
	//SF라고 써있음 static final <- final이 붙으면 상수가 된다
	//필드를 상수로 사용할 때는 SNAKE_표기법 으로 쓴다
	String PRINT = "넓이 : ";
	
	public void print();
	public void make();
	
}
