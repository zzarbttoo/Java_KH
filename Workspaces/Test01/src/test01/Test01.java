package test01;

import java.util.Scanner;

public class Test01 {

	// 12번 문제

	public static void main(String[] args) {

		methodIf();
		methodSwitch();
	}

	private static void methodIf() {

		int fi;
		int se;
		int eq = 0;
		String me;
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("연산 >>");
			fi = sc.nextInt();
			me = sc.next();
			se = sc.nextInt();

			if (me.equals("+")) {

				eq = fi + se;
			} else if (me.equals("-")) {
				eq = fi - se;
			} else if (me.equals("*")) {
				eq = fi * se;
			} else {

				if (se == 0) {
					System.out.println("0으로 나눌 수 없습니다");
					break;
				}
				eq = fi / se;
			}
			System.out.println(fi + me + se + "의 계산 결과는 " + eq);
		}

		

	}

	private static void methodSwitch() {

		int fi;
		int se;
		int eq;
		String me;
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("연산 >>");
			fi = sc.nextInt();
			me = sc.next();
			se = sc.nextInt();

			// me == "/"를 쓰면 안되고, me.equals 를 써서 직접 값을 비교해야한다
			if (se == 0 && me.equals("/")) {
				System.out.println("0으로 나눌 수 없습니다");
				break;
			}
			switch (me) {
			case "+":
				eq = fi + se;
				break;
			case "*":
				eq = fi * se;
				break;
			case "/":
				eq = fi / se;
				break;
			case "-":
				eq = fi - se;
				break;

			default:
				eq = 0;
			}

			System.out.println(fi + me + se + "의 계산 결과는 " + eq);

		}

	}

}
