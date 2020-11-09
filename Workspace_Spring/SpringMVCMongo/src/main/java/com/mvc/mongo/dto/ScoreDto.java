package com.mvc.mongo.dto;

import org.springframework.data.annotation.Id;

public class ScoreDto {
	
	//_id
	//@Id 를 통해 _id 라고 언급을 해주는 것이다
	@Id
	private String id;
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private String test;
	
	public ScoreDto() {
	}

	public ScoreDto(String id, String name, int kor, int eng, int math, String test) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.test = test;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "ScoreDto [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", test="
				+ test + "]";
	}
	
	
	
	

}
