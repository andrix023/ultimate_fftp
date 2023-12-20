package com.example.fromfridgetoplate.logic.control;

import com.example.fromfridgetoplate.logic.bean.RegistrationBean;

import com.example.fromfridgetoplate.logic.dao.ShopDAO;
import com.example.fromfridgetoplate.logic.model.Shop;
import com.example.fromfridgetoplate.patterns.factory.UserFactory;


public class RegisterController {
    public boolean register(RegistrationBean registrationBean){
        UserFactory userFactory = new UserFactory();
        ShopDAO shopDAO = new ShopDAO();

        Shop newShop = (Shop) userFactory.createUser(registrationBean);
        return shopDAO.saveShop(newShop.getEmail(), newShop.getPassword(), newShop.getName(), newShop.getVATnumber(), newShop.getAddress(), newShop.getPhoneNumber());

    }
}
