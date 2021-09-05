package com.example.hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User() {
        this.name=null;
        this.age= 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
