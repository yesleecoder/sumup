/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/17 16:57
 */
package main.com.lee.MultiThread.waitnotify.Test1;

import java.util.HashMap;

/**
 * 账户类
 * 该例子模仿多人存取同一个账户：
 */
public class Account {
    private static HashMap<String, Integer> m = new HashMap<String, Integer>();
    private static long times = 0;
    static {
        m.put("ren", 1000);
    }

    public synchronized void save(String name, int num) {
        long tempTime = times++;
        System.out.println("第 " + tempTime + " 次存储" + num + "之前" + name    + "的余额为：" + m.get(name));
        m.put(name, m.get(name) + num);
        this.notify();
        System.out.println("第 " + tempTime + " 次存储" + num + "之后" + name + "的余额为：" + m.get(name));
    }

    public static int get(String name) {
        return m.get(name);
    }

    /**
     * 注意wait的用法，必须在loop中，必须在拥有锁的代码块中。 前者是当被notify的时候要重新进行条件判断，后者是为了释放锁。
     *
     * @param name
     * @param num
     */
    public synchronized void load(String name, int num) {
        long tempTime = times++;
        System.out.println("第 " + tempTime + " 次提取" + num + "之前" + name + "的余额为：" + m.get(name));

        try {
            while (m.get(name) < num) {
                System.out.println("第 " + tempTime + " 次提取" + "余额" + m.get(name) + "不足，开始等待wait。");
                this.wait();
                System.out.println("第 " + tempTime + " 次提取操作被唤醒");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        m.put(name, m.get(name) - num);
        System.out.println("第 " + tempTime + " 次提取" + num + "之后" + name + "的余额为：" + m.get(name));
    }
}