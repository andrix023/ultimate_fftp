package com.example.fromfridgetoplate.logic.engineering;

import com.example.fromfridgetoplate.logic.bean.RegistrationBean;
import com.example.fromfridgetoplate.logic.model.Client;
import com.example.fromfridgetoplate.logic.model.Role;
import com.example.fromfridgetoplate.logic.model.User;

public class UserFactory {
    public User createUser(RegistrationBean registrationBean){  /* ha senso passare una bean alla factory???*/
        if(registrationBean.getRole() == Role.CLIENT){
            return new Client(registrationBean.getEmail(), registrationBean.getPassword(), registrationBean.getName(), registrationBean.getSurname(), registrationBean.getAddress());
        }
        else {
            return new User(registrationBean.getEmail(), registrationBean.getPassword());    /* qui andrebbe if il ruolo è rider o owner creo le altre due entity, questo è un placeholder per evitare errori del compilatore*/
        }
    }
}
