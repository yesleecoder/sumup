/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:30
 */
package main.com.lee.MultiThread;

/**
 *  加深对　synchronized 　和　wait　notify　 的理解
 *  依次打印　 1 2 1 2 1 2 1 2 1 2 1 2
 */
public class Test {


    public static boolean flag=true;


    public static void main(String[] args) {
        String obj= new String();
        new Thread(new A(obj)).start();

        new Thread(new B(obj)).start();
    }
}
class A implements Runnable {

    String s= new String();
    public A(String s){
        this.s=s;
    }
    public void run() {
        try {
            while (true) {
                synchronized(s){
                    s.notify();
                    s.wait();
                    Thread.sleep(1000);
                    System.out.println("1");

                }}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
class B implements Runnable {

    String s= new String();

    public B(String s){
        this.s=s;
    }

    public void run() {
        try {
            while (true) {
                synchronized(s){
                    s.notify(); //注解1
                    s.wait();
                    Thread.sleep(1000);
                    System.out.println("2");
                }}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

