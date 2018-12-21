/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:05
 */
package main.com.lee.Design_Mode.factory.factory_method.simple;

/**
 * 邮件实现类
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}