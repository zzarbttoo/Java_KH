package com.test06;

public class BeanFactory {

	Object getBean(String name) {
		if(name.equals("samsong")) {
			return new SamsongTV();
		}else if(name.equals("ig")) {
			return new IgTV();
		}
		return null;
	}
	
}
