package com.example.fromfridgetoplate.guicontroller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseUserGraphicController implements Initializable {
    @FXML
    private RadioButton clientButton;
    @FXML
    private RadioButton ownerButton;
    @FXML
    private Button continueButton;
    @FXML
    private Button backButton;

    Navigator navigator = Navigator.getInstance(null);

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        continueButton.setOnMouseClicked(event ->{
            if(clientButton.isSelected()){
                try {
                    navigator.goTo("clientSigninPage.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);  /*qui dovremmo fare un'eccezzione nostra, non usare quella a runtime*/
                }
            } else if (ownerButton.isSelected()) {
                /* todo
                  registrazione di uno shop owner
                  */
            }
        });
        backButton.setOnMouseClicked(event ->{
            try {
                navigator.goTo("loginPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
