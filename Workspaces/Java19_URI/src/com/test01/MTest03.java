package com.test01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MTest03 {

	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
	
		//google 메인화면의 html 코드를 들고왔다 
		URLConnection urlConnection = new URL("http://www.google.com").openConnection();
		BufferedInputStream buff = new BufferedInputStream(urlConnection.getInputStream());
		
		
		int byteRead;
		while((byteRead = buff.read()) != -1) {
			
			System.out.print((char)byteRead);
			
			
		}
		buff.close();
		
		
		
	}
	
	
}
