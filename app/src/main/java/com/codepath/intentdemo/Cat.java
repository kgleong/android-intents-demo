package com.codepath.intentdemo;

import java.io.Serializable;

public class Cat implements Serializable {
    private static final long serialVersionUID = -7058071762518995512L;

    String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
