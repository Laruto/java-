package com.wc.Demo.Decorator;

/**
 * Created by WC on 2019/1/13
 */

public class Client {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }
}
