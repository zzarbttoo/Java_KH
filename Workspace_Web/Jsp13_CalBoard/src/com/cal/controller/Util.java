package com.cal.controller;

public class Util {

	// msg가 한글자짜리이면 두글자로 바꿔주라
	public static String isTwo(String msg) {

		/*
		 * if (msg.length() == 1) {
		 * 
		 * return "0" + msg;
		 * 
		 * } else {
		 * 
		 * return msg; }
		 * 
		 */

		return (msg.length() < 2) ? "0" + msg : msg;

	}

}
