package com.wc.Demo.Observer;

/**
 * @Description TODO
 * @Date 2018/11/30 16:50
 * @Created by WC
 */

public class User implements Observer {
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
