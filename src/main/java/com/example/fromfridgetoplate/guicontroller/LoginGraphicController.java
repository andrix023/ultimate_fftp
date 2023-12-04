package com.example.fromfridgetoplate.guicontroller;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginGraphicController implements Initializable {
    @FXML
    private Button loginButton;
    Navigator navigator = Navigator.getInstance(null);

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        loginButton.setOnMouseClicked(event -> {
            try {
                navigator.goTo("homePage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
