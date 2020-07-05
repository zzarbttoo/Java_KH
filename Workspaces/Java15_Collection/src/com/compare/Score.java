package com.compare;

public class Score implements Comparable<Object>{

	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	
	public Score(){
		
	}
	
	public Score(String name, int kor, int eng, int math) {
		
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getKor() {
		return kor;
	}
	
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	

	public int getEng() {
		return eng;
	}
	
	public void setMath(int math) {
		
		this.math = math;
	}
	
	public int getMath() {
		return math;
	}
	
	
	public int getSum() {
		
		return kor + eng + math;
	}
	
	public double getAvg() {
		
		return getSum()/3.0;
	}
	
	public String getGrade() {
		
		
		int selection = (int ) getAvg()/10;
		switch(selection) {
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

	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", getName()=" + getName()
				+ ", getKor()=" + getKor() + ", getEng()=" + getEng() + ", getMath()=" + getMath() + ", getSum()="
				+ getSum() + ", getAvg()=" + getAvg() + ", getGrade()=" + getGrade() + "]";
	}

	
	//나와 다른 객체를 비교한다
	@Override
	public int compareTo(Object o) {
		
		Score other = (Score) o;
		
		//작은 것부터 차례대로 정렬 : 오름차순
		// 1(양수)이면 앞의 인자가 더 큰값
		// 0이면 같은 값
		// -1(음수)이면 뒤의 인자가 더 큰 값
		
		if(this.getKor() > other.getKor()) {
			return 1;
		}else if(this.getKor() < other.getKor()) {
			return -1;
		}else {
			
			if(this.getEng() > other.getEng()) {
				return 1;
			}else if(this.getEng() < other.getEng()) {
				return -1;
			}else {
				return 0;
			}
		}
		//같으면
	}


	
	
	
}
