package com.example.fromfridgetoplate.guicontrollers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GenericGraphicController implements Initializable {
    @FXML
    private Button profileButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button aboutButton;
    Navigator navigator = Navigator.getInstance(null);


    //method called as soon as the view is loaded
    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

        homeButton.setOnMouseClicked(event -> {
            try {
                navigator.goTo("clientHomePage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
/*
        aboutButton.setOnMouseClicked(event -> {
            try {
                navigator.goTo("guicontrollers/aboutPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }); */
        profileButton.setOnMouseClicked(event -> {
            try {
                navigator.goTo("guicontrollers/profilePage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
