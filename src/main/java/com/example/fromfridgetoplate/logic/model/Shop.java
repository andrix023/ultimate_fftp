package com.example.fromfridgetoplate.logic.model;

public class Shop extends User {
    private String name;

    private String address;
    private String VATnumber;
    private String phoneNumber;



    public Shop(String email, String password, String name, String address, String VATnumber, String phoneNumber) {
        super(email,password);
        this.name = name;
        this.address = address;
        this.VATnumber = VATnumber;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getVATnumber() {
        return VATnumber;
    }

    public String getAddress() {
        return address;
    }
}
