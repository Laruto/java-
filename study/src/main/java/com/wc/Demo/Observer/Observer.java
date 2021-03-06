package com.wc.Demo.Observer;

/**
 * @Description 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * @Date 2018/11/30 16:50
 * @Created by WC
 */

public interface Observer {
    public void update(String message);
}
