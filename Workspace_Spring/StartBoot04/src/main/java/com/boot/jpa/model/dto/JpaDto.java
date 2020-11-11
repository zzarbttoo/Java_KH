package com.boot.jpa.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MYBOARD")
public class JpaDto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int myno;
	
	@Column
	private String myname;
	
	@Column
	private String mycontent;
	
	@Column
	private String mytitle;
	
	@Column
	private Date mydate;

	public JpaDto() {
		// TODO Auto-generated constructor stub
	}

	public JpaDto(int myno, String myname, String mycontent, String mytitle, Date mydate) {
		this.myno = myno;
		this.myname = myname;
		this.mycontent = mycontent;
		this.mytitle = mytitle;
		this.mydate = mydate;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
}
