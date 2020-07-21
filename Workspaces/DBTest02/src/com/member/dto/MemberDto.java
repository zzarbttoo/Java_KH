package com.member.dto;

//DTO : Data Transfer Object : 값을 저장한 객체
//VO : Value Object
public class MemberDto {

	// 내가 가지고 오고 싶은 사람은 memberboard의 값
	// table의 컬럼 이름과 Dto의 필드 이름을 똑같이 하고,
	// 필드 이름은 소문자로 해줘야한다
	// 해당 테이블의 한 줄의 값(8개) 만 받을 수 있다
	private int mno;
	private String mname;
	private int mage;
	private String mgender;
	private String mlocation;
	private String mjob;
	private String mtel;
	private String memail;

	// 생성자

	public MemberDto() {

	}

	public MemberDto(int mno, String mname, int mage, String mgender, String mlocation, String mjob, String mtel,
			String memail) {

		this.mno = mno;
		this.mname = mname;
		this.mage = mage;
		this.mgender = mgender;
		this.mlocation = mlocation;
		this.mjob = mjob;
		this.mtel = mtel;
		this.memail = memail;

	}

	// getter & setter

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getMno() {

		return this.mno;
	}

	public String getMgender() {
		return this.mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMemail() {
		return memail;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMage(int mage) {
		this.mage = mage;
	}

	public int getMage() {
		return this.mage;
	}

	public void setMlocation(String mlocation) {
		this.mlocation = mlocation;
	}

	public String getMlocation() {
		return this.mlocation;
	}

	public void setMjob(String mjob) {

		this.mjob = mjob;
	}

	public String getMjob() {

		return this.mjob;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMtel() {

		return this.mtel;
	}

	public void setMemail(String memail) {

		this.memail = memail;
	}

	@Override
	public String toString() {
		
		return String.format("%3d %5s %3d %2s %10s %5s %10s %10s\n", mno, mname, mage,mgender, mlocation, mjob, mtel, memail);
	
	}

	


	
}
