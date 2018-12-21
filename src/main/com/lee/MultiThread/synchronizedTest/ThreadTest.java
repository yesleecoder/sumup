/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 14:29
 */
package main.com.lee.MultiThread.synchronizedTest;

/**
 * 为了测试　加和不加　synchronized 关键字区别
 *此例中　synchronized 修饰方法　则表示对实例对象加锁
 *
 * 测试结果：　如果不加synchronized关键字，则两个线程同时执行execute()方法，输出是两组并发的。
 　　         如果加上synchronized关键字，则会先输出一组0到9，然后再输出下一组，说明两个线程是顺次执行的。
 */
public class ThreadTest
{
    public static void main(String[] args)
    {
        Example example = new Example();    // 注意这里操作的是同一对象

        Thread t1 = new Thread1(example);   // 注意这里操作的是同一对象
        Thread t2 = new Thread1(example);   // 注意这里操作的是同一对象

        t1.start();
        t2.start();
    }

}

class Example
{
    public synchronized void execute()
    {
        for (int i = 0; i < 10; ++i)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Hello: " + i);
        }
    }

}

class Thread1 extends Thread
{
    private Example example;

    public Thread1(Example example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
        example.execute();
    }

}
