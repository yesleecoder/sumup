package main.com.lee.io.fileoperation;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	/**
	 *  File　类的各种操作
	 */
	public static void main(String[] args) {
		// 了解构造函数的情况  查帮助
		File file = new File("E:\\javaio\\imooc");
		//System.out.println(file.exists());
		if(!file.exists())
			file.mkdir(); //file.mkdirs()
		/*
			java mkdir()和mkdirs()区别
			mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹， 如下：
			new File("/tmp/one/two/three").mkdirs();
			执行后， 会建立tmp/one/two/three四级目录
			new File("/tmp/one/two/three").mkdir();
			则不会建立任何目录， 因为找不到/tmp/one/two目录， 结果返回false
		*/
		else
			file.delete();
		//是否是一个目录  如果是目录返回true,如果不是目录or目录不存在返回的是false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());

		//File file2 = new File("e:\\javaio\\日记1.txt");
		File file2 = new File("e:\\javaio","日记1.txt");
		if(!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			file2.delete();
		//常用的File对象的API
		System.out.println(file);//file.toString()的内容
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
