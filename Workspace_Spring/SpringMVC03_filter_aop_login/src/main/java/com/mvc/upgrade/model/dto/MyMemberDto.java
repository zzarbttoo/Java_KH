package com.mvc.upgrade.model.dto;

public class MyMemberDto {

	private int memberno;
	private String memberid;
	private String memberpw;
	private String name;

	public MyMemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MyMemberDto(int memberno, String memberid, String memberpw, String name) {
		this.memberno = memberno;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.name = name;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberpw() {
		return memberpw;
	}

	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
