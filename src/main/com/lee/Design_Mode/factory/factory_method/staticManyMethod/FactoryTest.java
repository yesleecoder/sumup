/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:20
 */
package main.com.lee.Design_Mode.factory.factory_method.staticManyMethod;

/**
 * 测试方法
 */
public class FactoryTest {
   // 这里跟多个工厂方法模式区别就是不需要创建实例
    public static void main(String[] args) {

        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}