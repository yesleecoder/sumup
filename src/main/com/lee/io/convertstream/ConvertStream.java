/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/19 15:46
 */
package main.com.lee.io.convertstream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 转化流：将字节流转化成字符流的流
 *
 */
public class ConvertStream {
    public static void main(String[] args) {
        // in是一个字节流，在接收中文时会有问题，因此用Scanner包装了一下
        // Scanner scan = new Scanner(System.in);

        /*
         * in是字节流，接收中文时会有问题，
         * 因此，使用InputStreamReader转化流，将字节流转化为字符流。
         * 字符流最高效的用法是缓冲流
         */
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入您想说的内容：");
        try {
            String say = br.readLine();
            System.out.println("您想说的是：" + say);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
