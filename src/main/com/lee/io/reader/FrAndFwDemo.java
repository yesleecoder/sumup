package main.com.lee.io.reader;

import java.io.*;

/**
 *  FileReader  字符流主要对字符串操作　
 */
public class FrAndFwDemo {
	public static void main(String[] args) throws IOException{
		//  文件字符流的方法
		FileReader fr = new FileReader("e:\\test.txt");
		FileWriter fw = new FileWriter("e:\\test2.txt");
		//FileWriter fw = new FileWriter("e:\\javaio\\imooc2.txt",true);
		char[] buffer = new char[2056];
		int c ;
		while((c = fr.read(buffer,0,buffer.length))!=-1){
			fw.write(buffer,0,c);
			fw.flush();
		}
		fr.close();
		fw.close();

		// 文件字节流的方法
		FileInputStream in = new FileInputStream("e:\\test.txt");
		FileOutputStream out = new FileOutputStream("e:\\test3.txt");
		byte[] buffer1 = new byte[8*1024];
		int i;
		while((i = in.read(buffer1,0,buffer.length))!=-1){
			out.write(buffer1,0,i);
			out.flush();
		}
		in.close();
		out.close();

	}


}
