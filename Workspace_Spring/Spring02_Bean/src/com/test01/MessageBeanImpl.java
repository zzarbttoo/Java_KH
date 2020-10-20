package com.test01;

public class MessageBeanImpl implements MessageBean{

	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		
		this.fruit = "Strawberry";
		this.cost = 10000;
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		
		this.fruit = fruit;
		this.cost = cost;
	}
	
	@Override
	public void sayHello(String name) {
		
		System.out.println(name + "이(가) 좋아하는 과일은" + fruit + "이고 가격은 " + cost + "입니다");
		
		
	}

	
}
