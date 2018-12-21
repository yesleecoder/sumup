/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:38
 */
package main.com.lee.MultiThread;

/**
 * 加深对wait　notify　理解
 *
 * 从程序运行的结果来看就不难理解wait/notify了，wait是让使用wait方法的对象等待，暂时先把对象锁给让出来，给其它持有该锁的对象用，
 * 其它对象用完后再告知（notify）等待的那个对象可以继续执行了，整个过程就是这样。wait/notify主要用于一个线程要等待另一个线程执行完后，然后得到执行结果的情况。
 */

public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();//主线程中启动另外一个线程　　 因为子线程需要的时间较长　所以先执行后面的程序
        System.out.println("b is start....");
        //括号里的b是什么意思,应该很好理解吧
        synchronized(b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();//这一句是什么意思，究竟谁等待?
                System.out.println("ThreadB is Completed. Now back to main thread");
            }catch (InterruptedException e){}
        }
        System.out.println("Total is :" + b.total);
    }
}

class ThreadB extends Thread {
    int total;
    public void run() {
        synchronized(this) {
            System.out.println("ThreadB is running..");
            for (int i=0; i<=100; i++ ) {
                total += i;
            }
            System.out.println("total is " + total);
            notify();
        }
    }
}
