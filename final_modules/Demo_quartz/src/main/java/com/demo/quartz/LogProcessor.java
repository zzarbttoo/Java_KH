package com.demo.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogProcessor {

	
	public void process() {
		
		Calendar nowTime = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("[yyyy-MM-dd:mm:ss]");
		String strNowTime = simpledate.format(nowTime.getTime());
		
		System.out.println(strNowTime + ":로그처리");
		
		
	
	}
	
}
