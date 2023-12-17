package com.example.fromfridgetoplate.logic.control;

import com.example.fromfridgetoplate.logic.bean.RegistrationBean;
import com.example.fromfridgetoplate.logic.dao.ClientDAO;
import com.example.fromfridgetoplate.logic.engineering.UserFactory;
import com.example.fromfridgetoplate.logic.model.Client;


public class RegisterController {
    public boolean register(RegistrationBean registrationBean){
        UserFactory userFactory = new UserFactory();
        ClientDAO clientDAO = new ClientDAO();

        Client newClient = (Client) userFactory.createUser(registrationBean);
        return clientDAO.saveClient(newClient.getEmail(), newClient.getPassword(), newClient.getName(), newClient.getSurname(), newClient.getAddress());

    }
}
