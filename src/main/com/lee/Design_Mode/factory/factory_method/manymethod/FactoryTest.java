/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:20
 */
package main.com.lee.Design_Mode.factory.factory_method.manymethod;

/**
 * 测试方法
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();
    }
}