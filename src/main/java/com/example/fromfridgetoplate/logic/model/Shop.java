package com.example.fromfridgetoplate.logic.model;

import com.example.fromfridgetoplate.logic.bean.ShopBean;
import com.example.fromfridgetoplate.logic.dao.ShopDAO;

public class Shop extends User {
    private String name;

    private String address;
    private String VATnumber;
    private String phoneNumber;

    public Shop() {
    }

    public Shop(String email, String password, String name, String address, String VATnumber, String phoneNumber) {
        super(email,password);
        this.name = name;
        this.address = address;
        this.VATnumber = VATnumber;
        this.phoneNumber = phoneNumber;
    }

    public Shop(String email, String name, String address, String VATnumber, String phoneNumber) {
        super(email);
        this.name = name;
        this.address = address;
        this.VATnumber = VATnumber;
        this.phoneNumber = phoneNumber;
    }
    public ShopBean getShopByEmail(String email){ // sono molto in dubbio che questo metodo sia corretto
        ShopDAO shopDAO = new ShopDAO(); // qui dovrei usare la dao factory
        Shop shop = shopDAO.retrieveShopByEmail(email);
        return new ShopBean(shop.getName(), shop.getAddress(), shop.getPhoneNumber(), shop.getVATnumber());
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
