/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:59
 */
package main.com.lee.MultiThread.waitnotify.Test2;

public class TestObjLock {
    public static void main(String[] args) {
        ObjLock ol = new ObjLock(1);
        Thread th1 = new Thread(ol,"producer");
        Thread th2 = new Thread(ol,"consumer");
        Thread th3 = new Thread(ol,"producer");
        Thread th4 = new Thread(ol,"consumer");
        Thread th5 = new Thread(ol,"producer");
        Thread th6 = new Thread(ol,"consumer");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
    }
}
