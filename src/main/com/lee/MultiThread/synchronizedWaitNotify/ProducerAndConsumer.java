/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 15:54
 */
package main.com.lee.MultiThread.synchronizedWaitNotify;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 下面来看一个生产者消费者模型，他们有一个缓冲区，缓冲区有最大限制，当缓冲区满的时候，生产者是不能将产品放入到缓冲区里面的，
 当然，当缓冲区是空的时候，消费者也不能从中拿出来产品，这就涉及到了在多线程中的条件判断，java中提供了wait和notify方法，
 他们可以在线程不满足要求的时候让线程让出来资源等待，当有资源的时候再notify他们让他们继续工作。
 */
class EventStorage {
    private int maxSize;
    private List<Date> storage;
    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<Date>();
    }
    public synchronized void set() {
        while(storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("Set: "+storage.size());
        notifyAll();
    }
    public synchronized void get() {
        while(storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get: "+storage.size()+" "+((LinkedList<Date>)storage).poll());
        notifyAll();
    }
}
class Producer implements Runnable {
    private EventStorage storge;
    public Producer(EventStorage storage) {
        this.storge = storage;
    }
    public void run() {
        for(int i = 0; i < 100; i++) {
            storge.set();
        }
    }
}
class Consumer implements Runnable {
    private EventStorage storage;
    public Consumer(EventStorage storage) {
        this.storage = storage;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args){
        EventStorage eventStorage=new EventStorage();
        Thread t1=new Thread(new Producer(eventStorage));
        Thread t2=new Thread(new Consumer(eventStorage));
        t1.start();
        t2.start();
    }
}
