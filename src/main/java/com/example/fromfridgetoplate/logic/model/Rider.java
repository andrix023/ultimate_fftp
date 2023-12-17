package com.example.fromfridgetoplate.logic.model;

public class Rider extends User{
    private String name;
    private String surname;

    public Rider(String email, String password, String name, String surname) {
        super(email, password);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
