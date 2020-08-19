package com.mvc.model.dto;

import java.util.Date;

public class LoginDto {

	private int num;
	private String writer;
	private String id;
	private String password;
	private String phonenumber;
	private Date comedate;
	
	public LoginDto() {
		
	}
	
	public LoginDto(int num, String writer, String id, String password, String phonenumber, Date comedate) {
		this.num = num;
		this.writer = writer;
		this.id = id;
		this.password = password;
		this.phonenumber = phonenumber;
		this.comedate = comedate;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getComedate() {
		return comedate;
	}
	public void setComedate(Date comedate) {
		this.comedate = comedate;
	}


}
