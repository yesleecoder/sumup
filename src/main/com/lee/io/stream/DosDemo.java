package main.com.lee.io.stream;

import main.com.lee.io.stream.IOUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataOutputStream  类
 */
public class DosDemo {
	public static void main(String[] args) throws IOException {
		String file = "demo/dos.dat";
		DataOutputStream dos = new DataOutputStream(
				new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//采用utf-8编码写出　　　3个字节存储一个汉字
		dos.writeUTF("中国");
		//采用utf-16be编码写出　　4 个字节存储一个汉字
		dos.writeChars("中国");
		dos.close();
		IOUtil.printHex(file);
	}

}
