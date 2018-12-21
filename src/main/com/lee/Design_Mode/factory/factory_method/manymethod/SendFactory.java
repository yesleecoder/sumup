/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:19
 */
package main.com.lee.Design_Mode.factory.factory_method.manymethod;

/**
 * 　多个工厂方法　
 */
public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
