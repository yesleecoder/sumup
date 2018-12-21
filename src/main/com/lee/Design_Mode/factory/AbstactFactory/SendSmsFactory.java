/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/16 11:35
 */
package main.com.lee.Design_Mode.factory.AbstactFactory;

public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
