package com.example.demo.domain.models;

public class Student {

    private final String uuid;
    private final String name;
    private final String email;
    private final String password;
    private final String role;

    public Student(String uuid, String name, String email, String password, String role) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
