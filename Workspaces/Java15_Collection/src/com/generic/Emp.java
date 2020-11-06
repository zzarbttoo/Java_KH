package com.generic;

// T : type 		
// K : key
// V : value
// E : element

public class Emp<T> {

	
	//empno type을 마음대로 넣을 수 있다
	private T empno;
	private String ename;
	
	public Emp() {
	
	}
	
	public Emp(T empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}


	public T getEmpno() {
		return empno;
	}


	public void setEmpno(T empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}
	
	
	
	
	
	
}
