package com.test01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCalc {

	public int calculation() {

		int res = 0;

		while (true) {
			//예외가 발생할 수 있는 명령들
			try {

				res = inputNumber() / inputNumber();
				//정상적으로 동작했을 때 break를 이용해 종료
				break;
				
			} catch (InputMismatchException e) {
				//예외가 발생햇을 때 수행할 명령문

				res = 3000;
				// e.printStackTrace(); //예외가 어디서 발생했는지 보여준다
				System.out.println(e); // 발생한 예외의 이름을 보여준다

				System.out.println("잘못 입력하셨습니다. 다시 입력받겠습니다");

			}catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력받겠습니다");
				
			}finally {
				//try명령/catch 명령이 다 끝난 후 무조건 실행하고자 하는 문장
				System.out.println("끝");
				
			}
		}
		
		return res;

	}

	public int inputNumber() {

		int n = 0;

		System.out.println("숫자만 입력해 주세요:");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		return n;
	}

}
