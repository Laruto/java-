package com.wc.Demo.Decorator;

/**
 * Created by WC on 2019/1/13
 */

public class DarkRoast implements Beverage {
    @Override
    public double cost() {
        return 1;
    }
}