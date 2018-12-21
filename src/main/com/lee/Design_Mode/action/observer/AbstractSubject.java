/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 9:34
 */
package main.com.lee.Design_Mode.action.observer;

import java.util.Enumeration;
import java.util.Vector;

public abstract  class AbstractSubject implements Subject{
    private Vector<Observer> vector = new Vector<Observer>();
    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }
}
