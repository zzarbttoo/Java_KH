package com.test06;

//왜 에러가 났었을까?
public class MyProfile extends Profile implements Display, Job {

	private String loc;
	//에러 사라짐
	public MyProfile(String name, String phone) {
		super(name, phone);
	}
	
	//setter이다(필드 값 초기화 해주는 역할)
	@Override
	public void jobLoc(String loc) {

		this.loc = loc;
		
	}

	
	@Override
	public void display() {

		//this.printProfile(); 도 가능하다(부모꺼 가져다 쓰는 것은 가능하므로 상관 x)
		super.printProfile();
		System.out.println("회사 주소 :" + loc);
		System.out.println("화시 직종 : " + JOB_ID);
		
	}

}
