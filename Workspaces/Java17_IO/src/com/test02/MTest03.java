package com.test02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MTest03 {

	public static void main(String[] args) {
		File fi = new File("c.txt");

		myInput(fi);
		myOutput(fi);
	}

	public static void myInput(File fi) {

		try (FileReader fr = new FileReader(fi)) {

			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void myOutput(File fi) {

		// try with resources
		// 괄호 안에는 열고 닫아야하는 객체를 써준다
		// 왜 열고 닫지 않을까? -> trywithresources는 자동으로 닫아준다
		try (FileWriter fw = new FileWriter(fi, true)) {

			fw.write("개는 훌륭하다.\n");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
