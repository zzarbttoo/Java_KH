package com.pstm.dto;

public class PagingTestDto {

	
	
	private int rn;
	private String name;
	
	public PagingTestDto() {
		
	}
	
	
	public PagingTestDto(int rn, String name) {
		this.rn = rn;
		this.name = name;
	}



	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
