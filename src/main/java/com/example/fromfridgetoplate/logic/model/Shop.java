package com.example.fromfridgetoplate.logic.model;

public class Shop extends User {
    private String name;

    private String address;
    private String VATnumber;

    public Shop(String email, String password, String name, String address, String VATnumber) {
        super(email, password);
        this.name = name;

        this.address = address;
        this.VATnumber = VATnumber; /*sarebbe la partita IVA*/
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
