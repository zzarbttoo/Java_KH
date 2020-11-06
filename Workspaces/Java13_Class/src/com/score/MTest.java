package com.score;

public class MTest {

	public static void main(String[] args) {
		
		String myName = "배유진";
		int myMath= 70;
		int myKor = 80;
		int myEng = 90;
		
		Score sco = new Score();
		
		sco.setName(myName);
		sco.setMath(myMath);
		sco.setKor(myKor);
		sco.setEng(myEng);
		
		
		
		System.out.println(sco); //해당 객체의 주솟값 출력
		//Override를 해서 주솟값 대신 점수가 나온다
		System.out.println("세 과목의 합은" + sco.getSum());
		System.out.println("세 과목의 평균은" + sco.getAvg());
		System.out.println("점수는" + sco.getGrade());
		
		//값이 자동으로 저장돼있는 것을 확인할 수 있다
		Score pengsu = new Score("펭수", 100, 70, 23);
		System.out.println(pengsu);
		
		
		
		
	}
	
}
