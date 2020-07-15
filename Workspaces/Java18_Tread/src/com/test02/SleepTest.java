package com.test02;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			
			//0.5珥덈쭏�떎 �븯�굹�뵫 �븯�듃媛� 利앷��븳�떎
			//main�뒪�젅�뱶媛� while�쓣 諛섎났�븷�뀗�뜲
			//Thread.sleep�쓣 �븷 �븣留덈떎 0.5留덈떎 �옍�떎
			
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(500);
				System.out.printf("%c", '솯');
			}
			System.out.println();
		}
		
	}
}
