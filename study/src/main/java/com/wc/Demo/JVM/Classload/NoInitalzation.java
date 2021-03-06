package com.wc.Demo.JVM.Classload;

import org.junit.Test;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */

public class NoInitalzation {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

    /**
     * 被动使用类字段演示二：
     * 通过数组定义来引用类，不会触发此类的初始化
     */
    @Test
    public void test1(){
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     * 被动使用类字段演示三：
     * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
     */
    @Test
    public void test2(){
        System.out.println(ConstClass.HELLOWORLD);
    }
}
