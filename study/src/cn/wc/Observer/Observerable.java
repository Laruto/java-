package cn.wc.Observer;

/**
 * @Description 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @Date 2018/11/30 16:50
 * @Created by WC
 */

public interface Observerable {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
