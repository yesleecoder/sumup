package main.com.lee.io.stream;

import main.com.lee.io.stream.IOUtil;

import java.io.IOException;

public class IOUtilTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IOUtil.printHex("e:\\javaio\\FileUtils.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
