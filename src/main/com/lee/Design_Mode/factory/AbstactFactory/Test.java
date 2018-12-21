/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:36
 */
package main.com.lee.Design_Mode.factory.AbstactFactory;

public class Test {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
