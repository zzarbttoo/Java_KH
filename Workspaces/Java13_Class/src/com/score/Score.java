package com.score;

public class Score {

	//private이기 때문에 다른 class에서 사용 불가
	//그래서 getter과 setter를 이용해 다른 class에서도 사용할 수 있도록 한다
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Score() {

	}

	public Score(String name, int kor, int eng, int math) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}

	// getter & setter

	// 기본적으로 get + 첫글자 대문자인 형태로 만든다
	
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

	public int getEng(){
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

	
	public int getSum() {
		//세 값의 총점
		//field를 전역변수로 만들었기 때문에 더하기 가능
		//this : Score 객체가 가지고 있는 것
		//class객체에 접근하여 들고 오는 것이므로 this.~는 nonstatic이다 
		return this.kor + this.eng + this.math;
	}
	public double getAvg() {
		//세 값의 평균
		return (double) getSum()/3;
	}
	public String getGrade() {
		// 100~90 : A
		// 89 ~80 : B
		// 79 ~70 : C
		// 69 ~60 : D
		// 59 ~   : F
		
		
//		if(getAvg() >= 90) {
//			return "A";
//		}else if(getAvg() >= 80) {
//			return "B";
//		}else if(getAvg() >=70) {
//			return "C";
//		}else if(getAvg() >= 60) {
//			return "D";
//		}else {
//			return "F";
//		}
		
		switch((int) getAvg()/10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
			
		}
		
	
	}
	//오타나면 Override 못한다고 에러난다
	@Override
	public String toString() {
		return " 이름 : " + name +
				" 국어 :" + kor + 
				" 영어 : " + eng +
				" 수학 :" + math + "\n" +
				" 총점 : " + getSum() + 
				" 평균 :" + getAvg() +
				" 등급 :" + getGrade();
				
		
	}
	
	
}
