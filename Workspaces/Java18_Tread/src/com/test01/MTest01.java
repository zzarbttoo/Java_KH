package com.test01;

import java.io.IOException;

public class MTest01 {

	
	public static void main(String[] args) {
		
		Runtime rt = Runtime.getRuntime(); //싱글톤
		
		try {
			
			//chrome의 위치값을 포함하여 exec() 로 외부 파일을 실행시켰다
			Process prc = rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	
		
		
	}
	
	
}
