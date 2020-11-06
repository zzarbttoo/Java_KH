package com.zir;

import java.util.Arrays;
import java.util.Scanner;

public class Temp01 {

	public static void main(String[] args) {

		int x;
		int y;
		int num;

		Scanner sc = new Scanner(System.in);

		System.out.println("지뢰는 몇개 있습니까(초급 : 3, 중급 : 5, 고급 :7  입력");
		num = sc.nextInt();
		System.out.println("x 좌표를 입력하시오");
		x = sc.nextInt();
		System.out.println("y 좌표를 입력하시오");
		y = sc.nextInt();

		zirFind(x, y, num);

	}

	private static void zirFind(int x, int y, int n) {

		int[][] zirArray = new int[10][10];

		while (true) {

			int sum = 0;
			int k;

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					zirArray[i][j] = (int) (Math.random() * 9) + 1;

					if (sum < n) {

						k = ((int) (Math.random() * 10) + 1);
						if (k == 8) {
							zirArray[i][j] = 0;
							sum++;

						}

					}
				}
			}

			if (sum == n)
				break;
		}

		if (zirArray[x][y] == 0) {
			System.out.println("폭탄입니다");
		} else {
			System.out.println("(" + x + "," + y + ")" + "값은" + zirArray[x][y] + "이다");
		}

		for (int t = 0; t < zirArray.length; t++) {
			System.out.println(Arrays.toString(zirArray[t]));

		}
	}
}
