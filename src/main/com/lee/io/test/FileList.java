/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/19 10:08
 */
package main.com.lee.io.test;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;

/**
 * 循环列出所有文件
 */
public class FileList {

    public static void main(String[] args) {
       new FileList().listFiles("E:\\1");
    }
    public  void listFiles(String filepath){

        File file = new File(filepath);
        if(file.isDirectory()){
            System.out.println(file.getName());
                File[] files = file.listFiles();
                for (File fileone:files){
                    listFiles(fileone.getAbsolutePath());
                }

        }else{
            System.out.println(file.getName());
        }
    }
}
