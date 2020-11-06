package com.score.dto;

public class ScoreDto {

	
	private String myName;
	private int myKor;
	private int myEng;
	private int myMath;
	private int mySum;
	private double myAvg;
	private String myGrade;
	
	
	
	
	public ScoreDto() {}
	
	public ScoreDto(String myName, int myKor, int myEng, int myMath, int mySum, double myAvg, String myGrade) {
		this.myName = myName;
		this.myKor = myKor;
		this.myEng = myEng;
		this.myMath = myMath;
		this.mySum = mySum;
		this.myAvg = myAvg;
		this.myGrade = myGrade;
	}

	public ScoreDto(String myName, int myKor, int myEng, int myMath) {
		
		
		this.myName = myName;
		this.myKor = myKor;
		this.myEng = myEng;
		this.myMath = myMath;
		setMySum();
		setMyAvg();
		setMyGrade();
					
	}
	
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public int getMyKor() {
		return myKor;
	}

	public void setMyKor(int myKor) {
		this.myKor = myKor;
	}

	public int getMyEng() {
		return myEng;
	}

	public void setMyEng(int myEng) {
		this.myEng = myEng;
	}

	public int getMyMath() {
		return myMath;
	}

	public void setMyMath(int myMath) {
		this.myMath = myMath;
	}

	public int getMySum() {
		return mySum;
	}

	//만들어주기 파라미터 있는 버전
	
	public void setMySum() {
		
		this.mySum = this.myKor + this.myEng + this.myMath;
	}

	public double getMyAvg() {
		return myAvg;
	}

	public void setMyAvg() {
		this.myAvg = this.getMySum()/3;
	}

	public String getMyGrade() {
		return myGrade;
	}

	public void setMyGrade() {
		
		switch((int)(this.myAvg/10)){
		
		case 10:
		case 9:
			this.myGrade = "A";
			break;
		case 8:
			this.myGrade = "B";
			break;
		case 7:
		case 6:
			this.myGrade = "C";
			break;
		default:
			this.myGrade= "F";
				
		}
		
		
	}

	@Override
	public String toString() {
		return "ScoreDto [myName=" + myName + ", myKor=" + myKor + ", myEng=" + myEng + ", myMath=" + myMath
				+ ", mySum=" + mySum + ", myAvg=" + myAvg + ", myGrade=" + myGrade + "]";
	}
	
	
	
	
	
	
}
