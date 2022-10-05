package com.example.testratel;

public class Person {

    public int other;
    public final int age;
    public final String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }



    public Person(String name, int age, int other) {
        this.age = age;
        this.name = name;
        this.other = other;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
