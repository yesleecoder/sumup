/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:58
 */
package main.com.lee.MultiThread.waitnotify.Test1;


/**
 * 用户类
 * 这里注意runnable接口的线程是怎么实例化的。new Thread(new User())
 * 这里成功展示了多个用户存取同一个账户的多线程实例，通过多线程同步，保证了安全的执行。
 * @author abc
 *
 */
public class User implements Runnable {
    private static Account account = new Account();
    private final int id;

    User(int i){
        id=i;
    }

    public void run() {
        int tempMoney = 100;
        account.load("ren", tempMoney);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        account.save("ren", 100);
        System.out.println("线程"+id+"完毕========================================================");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new User(i)).start();
        }
    }
}
