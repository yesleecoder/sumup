/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:05
 */
package main.com.lee.Design_Mode.factory.AbstactFactory;


/**
 * 短信实现类
 */
public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}