package com.test05;

//Area를 Impl했다 즉 Area를 상속받아서 만들었다
//추상클래스이기 때문에 무조건 모두 구현을 할 필요가 없다(어차피 객체화 못시킴)
public abstract class AreaImpl implements Area{
	
	private String result;

	@Override
	public void print() {
		//Area.PRINT 
		System.out.println(Area.PRINT + result);
	}
	
	@Override
	public abstract void make();
	
	public void setResult(String result) {
		this.result = result;
	}
	
	
	

}
