package com.gitlab.example.dto;
public class MyData {
    private String name;
    private int age;

    // Constructor
    public MyData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (or lombok annotations if lombok is used)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
