package com.wc.Demo.Proxy.dynamicProxy;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
