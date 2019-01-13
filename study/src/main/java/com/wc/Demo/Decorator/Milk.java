package com.wc.Demo.Decorator;

/**
 * Created by WC on 2019/1/13
 */

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
