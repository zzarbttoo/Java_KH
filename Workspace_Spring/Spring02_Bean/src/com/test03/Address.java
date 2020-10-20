package com.test03;

public class Address {

	private String name;
	private String addr;
	private String phone;
	
	
	//생성자가 없어짐
	//자바가 기본생성자를 자동 생성 해준다
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return "이름 : " + name + "\t 주소 :" + addr + "\t 전화번호 : " + phone;
		
	}
}
