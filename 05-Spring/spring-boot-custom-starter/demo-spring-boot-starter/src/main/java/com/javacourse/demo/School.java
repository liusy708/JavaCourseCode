package com.javacourse.demo;

public class School {

    private String name;

    public School(String name) {
        this.name = name;
    }

    public String msg() {
        return "this is school: " + this.name;
    }

}
