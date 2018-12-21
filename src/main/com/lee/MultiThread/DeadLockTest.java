/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 9:47
 */
package main.com.lee.MultiThread;

/**
 *  模拟 死锁出现问题。
 *  哲学家进餐问题　死锁
 *  lee song 两人 吃饭　　公用筷子1 筷子2  必须都拿到　才能吃饭
 */

public class DeadLockTest {
    public static void main(String[] args) {
        final String kuaizi1 = "kuaizi1";
        final String kuaizi2 = "kuaizi2";
        // t1 代表宋吃饭
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("song 等待筷子1");
                synchronized (kuaizi1){
                    System.out.println("song 拿到筷子1");
                    System.out.println("song 等待筷子2");
                    try {
                        Thread.sleep(1000);  // 这里是停顿一秒钟　为了使另一个可以获取资源
                    }
                    catch (Exception e){
                       e.printStackTrace();
                    }
                    synchronized (kuaizi2){
                        System.out.println("song 拿到筷子2");
                        System.out.println("song 开始吃饭");
                    }
                }
            }
        };
        t1.start();
        // t2 代表lee吃饭
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("lee 等待筷子2");
                synchronized (kuaizi2){
                    System.out.println("lee 拿到筷子2");
                    System.out.println("lee 等待筷子1");
                    try {
                        Thread.sleep(1000);     // 这里是停顿一秒钟　为了使另一个可以获取资源
                    }
                    catch (Exception e){
                        System.out.println("出错");
                    }
                    synchronized (kuaizi1){
                        System.out.println("lee 拿到筷子1");
                        System.out.println("lee 开始吃饭");
                    }
                }
            }
        };
        t2.start();


    }


}
