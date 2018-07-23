package com.training.spring.core.injectingcollections;

public class MyBean {

    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
