package com.wc.Demo.reflection;

import java.lang.reflect.Constructor;

public class main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
//        Employee e = new Employee("Harry Hacker");
//        Class cl = e.getClass();
//        String className = "com.wc.Demo.reflection.Employee";
//        try{
//            Class cl2 = Class.forName(className);
//            System.out.println(cl2.getName());
//            Object m = Class.forName(className).newInstance();
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }

        Class c = Class.forName("com.wc.Demo.reflection.Employee");
        Constructor[] constructors = c.getConstructors();

        for (Constructor constructor: constructors) {
            System.out.println(constructor);
        }
    }
}
