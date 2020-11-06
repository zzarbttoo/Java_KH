package com.my.dto;

public class Score {
	
	
	private String name;
	private int kor;
	private int math;
	private int eng;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
		
	}
	
	public Score(String name, int kor, int math, int eng, double avg) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}



	public Score(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.avg = (kor + eng + math)/3;
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

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getSum() {
		
		return kor + eng + math;
		
	}
	
	public double getAvg() {
		return getSum()/3.0;
	}
	
	public String getGrade(){
		
		switch((int)getAvg()/10) {
		
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		
		}
		
		return "F";
		
	}
	
	

}
