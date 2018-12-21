package main.com.lee.MultiThread;


/**
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC。这个问题用Object的wait()，notify()就可以很方便的解决。
 * 思路：所以每一个线程必须同时持有两个对象锁，才能继续执行。一个对象锁是prev，就是前一个线程所持有的对象锁。
 * 还有一个就是自身对象锁。主要的思想就是，为了控制执行的顺序，必须要先持有prev锁，
 * 也就前一个线程要释放自身对象锁，再去申请自身对象锁，两者兼备时打印，之后首先调用self.notify()释放自身对象锁，
 * 唤醒下一个等待线程，再调用prev.wait()释放prev对象锁，终止当前线程，等待循环结束后再次被唤醒。
 * 运行上述代码，可以发现三个线程循环打印ABC，共10次。
 * 程序运行的主要过程就是A线程最先运行，持有C,A对象锁，后释放A,C锁，唤醒B。线程B等待A锁，再申请B锁，后打印B，再释放B，A锁，唤醒C，线程C等待B锁，再申请C锁，后打印C，再释放C,B锁，唤醒A。
 * 看起来似乎没什么问题，但如果你仔细想一下，就会发现有问题，就是初始条件，三个线程按照A,B,C的顺序来启动，按照前面的思考，A唤醒B，B唤醒C，C再唤醒A。但是这种假设依赖于JVM中线程调度、执行的顺序。
 *
 *  wait notify 只能在同步块synchronized中使用
 */

public class ThreadTest implements Runnable {     
        
    private String name;     
    private Object prev;     
    private Object self;     
    
    private ThreadTest(String name, Object prev, Object self) {     
        this.name = name;     
        this.prev = prev;     
        this.self = self;     
    }     
    
    @Override    
    public void run() {     
        int count = 10;
            while (count > 0) {
                synchronized (prev) {
                synchronized (self) {     
                    System.out.print(name);     
                    count--;
                    self.notify();   // 　　 唤醒等待　self的资源
                }     
                try {     
                    prev.wait();     //　释放　prev的锁　
                } catch (InterruptedException e) {     
                    e.printStackTrace();     
                }     
            }     
    
        }     
    }     
    
    public static void main(String[] args) throws Exception {     
        Object a = new Object();     
        Object b = new Object();     
        Object c = new Object();     
        ThreadTest pa = new ThreadTest("A", c, a);     
        ThreadTest pb = new ThreadTest("B", a, b);     
        ThreadTest pc = new ThreadTest("C", b, c);     
             
             
        new Thread(pa).start();  
        Thread.sleep(100);  //确保按顺序A、B、C执行  
        new Thread(pb).start();  
        Thread.sleep(100);    
        new Thread(pc).start();     
        Thread.sleep(100);    
        }     
}    