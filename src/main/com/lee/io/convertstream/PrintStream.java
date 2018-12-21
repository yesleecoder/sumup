/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/19 15:48
 */
package main.com.lee.io.convertstream;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 打印流：PrintWriter
 * 它带有一个小的缓冲区，是轻量级的及时刷新缓冲的小流
 *
 *
 */
public class PrintStream {
    public static void main(String[] args) {
        File file = new File("a.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            // 打印流一定要加上true，否则就没有刷新缓冲功能
            PrintWriter out = new PrintWriter(
                    new FileWriter(file), true);
            String say = "hello java";
            out.write(say);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}