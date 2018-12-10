/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/10 15:18
 */
package main.com.lee;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/*
　参考：　　https://blog.csdn.net/xiao__gui/article/details/8934832
     这里将 ArrayList 换成 Vector 则 线程安全 不会产生偏差
     注意这里的话是 每个线程同时对一个ArrayList进行操作　会出现线程不安全　如果这里每个线程都创建一个　ArrayList　则线程安全。
 */

public class ThreadSafty {
    public static void main(String[] args) {
        // 进行10次测试
        for (int i = 0; i < 10; i++) {
            test();
        }
    }


    public static void test() {
        // 用来测试的List
       //   主线程中new的一个ArrayList然后多个线程操作同一个ArrayList对象  即操作同一个ArrayList 对象　所以产生问题
        List<Object> list = new ArrayList<Object>();    // 线程不安全
     //    Vector<Object>  vectors = new Vector<Object>();　　　// 线程安全
        // 线程数量(1000)
        int threadCount = 1000;

        // 用来让主线程等待threadCount个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // 启动threadCount个子线程
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new MyThread(list, countDownLatch));
            thread.start();
        }

        try {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // List的size
        System.out.println(list.size());
    }
}

class MyThread implements Runnable {
    private List<Object> list;

    private CountDownLatch countDownLatch;

    public MyThread(List<Object> list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        // 每个线程向List中添加100个元素
        for (int i = 0; i < 100; i++) {
            list.add(new Object());
        }

        // 完成一个子线程
        countDownLatch.countDown();
    }
}

