package com.test04;

public class Student {

	//main method: 프로그램의 주 진입점 
	public static void main(String[] args) {
		
		//한번에 이렇게 쓰는 거도 되기는 한데 그러나 추천하지는 않는다
		int kor, eng, math;
		kor= eng = math= 0;
		
		kor = 100;
		eng = 40;
		math = 71;
		
		//1번과 2번에서 만든 메소드를 활용해서
		
		
		int sum = 0; //sum이라는 변수를 초기화
		double avg = 0;
		
		sum = getSum(kor, eng, math);
		avg = getAvg(getSum(kor, eng, math));
		
		
		
		//총점과 평균을 출력하자
		System.out.println("총점 : " + sum);
		System.out.println("평균: " + avg);
	
		
	}
	
	//1. int 형 값 3개를 넣어주면, 3개 값의 총점을 int로 return 해주는 
	//getSum이라는 메소드를 만들자
	// 접근 제한은 같은 패키지 내에서만 가능 -> default(쓰는거 아님)
	//메모리는 static에 저장된다
	
	static int getSum(int a, int b, int c) {
		
		return (a + b + c);
		
	}
	
	
	//2. int 형 값 한개를 넣어주면, 해당 값의 1/3 을 실수로 return 해주는 
	//getAvg라는 메서드를 만들자
	//어디서나 접근/참조 가능하고,
	//메모리는 static 영역에 저장된다
	
	public static double getAvg(int sum) {
		
		//(int/int->int) 몫만 나온다
		//return 값이 double이므로 묵시적 형변환이 일어났다[계산하고 나서 double type으로 변환]
		//그래서 (double)로 형변환을 진행해줬다(double/int->double) [계산 전에 double type으로 변환]
		return (double) sum/3;
		
	}
	
}
