package main.com.lee.io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *  序列化　将对象转化成字节序列（字节数组），便于存储或者网络传输。
 *  重要的两个类：
 *  	序列化：ObjectOutputStream
 *  	ObjectOutputStream	oos = new ObjectOutputStream(new FileOutputStream(file));　　oos.writeObject(stu)
 *  	反序列化：ObjectInputStream
 *  	ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file)); Student stu = (Student)ois.readObject();
 */

public class ObjectSeriaDemo1 {
	public static void main(String[] args) throws Exception{
		String file = "demo/obj.dat";
		//1.对象的序列化
/*		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));
		Student stu = new Student("10001", "张三", 20);
		oos.writeObject(stu);
		oos.flush();
		oos.close();*/
		// 反序列化
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));
		Student stu = (Student)ois.readObject();
		System.out.println(stu);
		ois.close();

	}


}
