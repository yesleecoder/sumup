/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:07
 */
package main.com.lee.Design_Mode.factory.factory_method.simple;

/**
 * 测试类
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }
}