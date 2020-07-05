package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class MTest02 {

	
	public static void main(String[] args) throws IOException {
		
		String url = "https://images.mypetlife.co.kr/content/uploads/2019/09/04222847/dog-panting.jpg";
		
		//java.net
		URL u = new URL(url);
		
		URLConnection urlConnection = u.openConnection();
		//그림 링크에 접속
		urlConnection.connect();

		//data를 서버에서 응답해줬다
		
		DataInputStream di = new DataInputStream(urlConnection.getInputStream());
		
		//데이터를 사진으로 저장하자
		FileOutputStream fo = new FileOutputStream("a.jpg");
		byte[] b = new byte[1];
		while(di.read(b, 0, 1) !=-1) {
			fo.write(b, 0, 1);
		}
		
		fo.close();
		di.close();
		
	}
	
	
}
