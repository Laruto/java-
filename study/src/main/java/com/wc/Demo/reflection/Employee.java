package com.wc.Demo.reflection;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
        this.name = "defalut";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
