package com.generic;

public class MTest {

	public static void main(String[] args) {
		
		Emp samsong = new Emp("s001", "홍길동");
		Emp lg = new Emp("s001", "김선달");
		System.out.println(samsong);
		System.out.println(lg);
		
		lg.setEmpno("l1111");
		System.out.println(lg);
		
		
		//특정 값을 강제시키고 싶다
		Emp<String> cacao = new Emp<String>("k0001", "라이언");
		System.out.println(cacao);
		
		//책 116p
		//Emp eno type을 string으로 강제했기 때문에 더이상 되지 않는다
//		cacao.setEmpno(1112);
		
		
	}
	
	
}
