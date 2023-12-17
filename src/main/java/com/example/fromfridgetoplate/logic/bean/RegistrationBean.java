package com.example.fromfridgetoplate.logic.bean;

import com.example.fromfridgetoplate.logic.model.Role;

public class RegistrationBean {
    private String email;
    private String password;
    private String name;    /* nel caso dello shop diventa lo shopName */
    private String surname;
    private String address;
    private Role role;

    public RegistrationBean(String email, String password, String name, String surname,String address, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.role = role;
    }

    public RegistrationBean(String email, String password, String name, String surname, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;

    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }
}
