package test01;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {

		rSP();

	}

	private static void rSP() {

		String[] str = { "가위", "바위", "보" };
		int n;
		Scanner sc = new Scanner(System.in);
		String you;

		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다");

		while (true) {

			System.out.println("가위 바위 보!>>>>");
			you = sc.next();

			if (you.equals("그만")) {
				System.out.println("게임을 종료합니다 ...");
				break;
			}
			n = (int) (Math.random() * 3);
			if (str[n].equals(you)) {

				System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 비겼습니다.");

			} else if (str[n].equals("가위")) {

				if (you.equals("바위")) {

					System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 이겼습니다");
				} else {
					System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 졌습니다.");
				}

			} else if (str[n].equals("바위")) {
				if (you.equals("보")) {

					System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 이겼습니다.");
				} else {

					System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 졌습니다.");
				}

			} else {
				if (you.equals("바위")) {

					System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 졌습니다.");
				} else {

					System.out.println("사용자 = " + you + ", 컴퓨터=" + str[n] + ", 이겼습니다.");
				}

			}
		}
	}

}
