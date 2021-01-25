package com.example.javawebdemo.entity;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}