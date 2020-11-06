package com.hw.mvc.model.dto;

public class MyMemberDto {

	private int memberno;
	private String memberid;
	private String memberpw;
	private String membername;
	public MyMemberDto() {
	}
	public MyMemberDto(int memberno, String memberid, String memberpw, String membername) {
		this.memberno = memberno;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
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
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	
	
	
	
	
}
