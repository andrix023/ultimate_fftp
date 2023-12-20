package com.example.fromfridgetoplate.guicontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainPageGraphicController {
    @FXML
    private Button loginButton;
    @FXML
    private Button signInButton;
    @FXML
    private Button exitButton;
    Navigator navigator = Navigator.getInstance(null);

    @FXML
    void onButtonClicked(ActionEvent event) throws IOException {
        Node sourceNode = (Node) event.getSource() ;
        if(sourceNode == loginButton ){
            navigator.goTo("loginPage.fxml");
        }
        else if(sourceNode == signInButton){
            navigator.goTo("chooseUserPage.fxml");
        }
        else if(sourceNode == exitButton){
            /* da fare */
        }
    }

}
