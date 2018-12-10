/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/10 16:54
 */
package main.com.lee;

import java.util.concurrent.CountDownLatch;


public class ThreadSafty1
{
    public static void main(String[] args)
    {
        // 进行10次测试
        for(int i = 0; i < 10; i++)
        {
            test();
        }
    }

    public static void test()
    {
        // 计数器
        Counter counter = new Counter();

        // 线程数量(1000)
        int threadCount = 1000;

        // 用来让主线程等待threadCount个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // 启动threadCount个子线程
        for(int i = 0; i < threadCount; i++)
        {
            Thread thread = new Thread(new MyThread1(counter, countDownLatch));
            thread.start();
        }

        try
        {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // 计数器的值
        System.out.println(counter.getCount());
    }
}

class MyThread1 implements Runnable
{
    private Counter counter;

    private CountDownLatch countDownLatch;

    public MyThread1(Counter counter, CountDownLatch countDownLatch)
    {
        this.counter = counter;
        this.countDownLatch = countDownLatch;
    }

    public void run()
    {
        // 每个线程向Counter中进行10000次累加
        for(int i = 0; i < 10000; i++)
        {
            counter.addCount();
        }

        // 完成一个子线程
        countDownLatch.countDown();
    }
}

class Counter
{
    private int count = 0;

    public int getCount()
    {
        return count;
    }
  // 线程不安全
/*    public  void  addCount()
    {
        count++;
    }*/

    // 线程安全
    public  synchronized  void  addCount()
    {
        count++;
    }
}

