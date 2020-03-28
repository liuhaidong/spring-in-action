package com.arkdex.springinaction.disruptorqueue;

public class Animal {
    private int id;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Animal(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}