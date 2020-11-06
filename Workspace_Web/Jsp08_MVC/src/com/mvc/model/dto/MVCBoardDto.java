package com.mvc.model.dto;

import java.util.Date;

public class MVCBoardDto {

	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	public MVCBoardDto() {
		
		
	}
	
	public MVCBoardDto(String writer, String title, String content) {
		
		this.writer= writer;
		this.title = title;
		this.content = content;
	}
	
	public MVCBoardDto(int seq, String content, String title) {
		
		this.seq = seq;
		this.content = content;
		this.title = title;
	}
	
	public MVCBoardDto(int seq, String writer, String title, String content, Date regdate) {
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
	
}
