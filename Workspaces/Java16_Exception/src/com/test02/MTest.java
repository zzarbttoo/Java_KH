package com.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		int a = 0;

		// alt + shift + z 를 통해 for, try catch 등을 바로 감쌀 수 있다
		try {
			System.out.println("숫자를 입력해 주세요 :");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();

			if (a == 777) {
				//throw라는 키워드는 뒤의 예외를 발생한다
				throw new MyException();
			}
		}

		catch (InputMismatchException e) {

			System.out.println("잘못된 입력!");
		} catch (MyException e) {

			System.out.println("우리가 만든 예외");
			e.printStackTrace();
		} catch (Exception e) {
			// 무슨 exception이 발생할 지 모르므로, 부모 클래스인 Exception을 catch하도록 한다
			// 되긴 되는데, 원하는 exception마다 처리를 다르게 할 수 없다
			// 그리고 메모리를 많이 잡아먹는다
			System.out.println("모든 예외");

		}

	}

}
