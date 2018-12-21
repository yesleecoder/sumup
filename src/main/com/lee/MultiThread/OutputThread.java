/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:20
 */
package main.com.lee.MultiThread;

/**
 *  加深对　synchronized 　和　wait　notify　 的理解
 *  依次打印　 1 2 1 2 1 2 1 2 1 2 1 2
 */
public class OutputThread implements Runnable {
    private int num;
    private Object lock;

    public OutputThread(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    lock.notifyAll();   //注解1   目的使交替执行
                    lock.wait();
                    System.out.println(num);

                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Object lock = new Object();
        Thread thread1 = new Thread(new OutputThread(1, lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));
        thread2.start();
        thread1.start();
    }
}
