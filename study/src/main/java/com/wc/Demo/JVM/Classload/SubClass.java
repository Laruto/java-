package com.wc.Demo.JVM.Classload;

public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init");
    }
}
