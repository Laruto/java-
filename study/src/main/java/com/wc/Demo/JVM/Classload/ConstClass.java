package com.wc.Demo.JVM.Classload;

public class ConstClass {

    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLOWORLD = "hello world";
}
