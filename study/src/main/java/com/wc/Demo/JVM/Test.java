package com.wc.Demo.JVM;

/**静态语句块中只能访问到定义在静态语句块之前的变量
 * 定义在它之后的变量，在前面的静态语句块中可以赋值，但是不能访问
 * Created by WC on 2018/12/11
 */

public class Test {
    static {
        i = 0;                      //给变量赋值可以通过
//        System.out.println(i);      //这句编译器会提示“非法向前引用”
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);  //1
    }
}
