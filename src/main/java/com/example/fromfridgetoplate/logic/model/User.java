package com.example.fromfridgetoplate.logic.model;

import java.io.Serializable;

public class User implements Serializable {
    String email;
    Role role;

    public User(String email, Role role) {
        this.email = email;
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
