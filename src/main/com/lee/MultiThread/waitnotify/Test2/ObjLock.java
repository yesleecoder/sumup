/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:59
 */
package main.com.lee.MultiThread.waitnotify.Test2;

/**
 * 生产者（producer）与消费者（consumer）问题
 * 说明事物锁与多线程同步
 * 生产者生产,消费者消费,规则：但当库存为0时,消费者要消费是不行的；
 * 但当库存为上限(这里是10)时,生产者也不能生产
 */
public class ObjLock implements Runnable {
    private int count = 0;   //产品数

    private int locknum = 0; //上锁的线程数

    public ObjLock(int n){
        this.count = n;
    }

    //生产
    public synchronized void produce(){
        while(count == 10){
            locknum ++;
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        count ++;
        if(locknum > 0)
            locknum --;
        notify();
    }

    //消费
    public synchronized void consume(){
        while(count == 0){
            locknum ++;
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        count --;
        if(locknum > 0)
            locknum --;
        notify();
    }

    public void run() {
        while(true){
            if(Thread.currentThread().getName().substring(0, 8).equals("producer"))
                produce();
            else if(Thread.currentThread().getName().substring(0, 8).equals("consumer"))
                consume();
            System.out.println(Thread.currentThread().getName() + ": " + count + " ,locknum: " + locknum);
        }
    }
}