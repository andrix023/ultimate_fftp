package com.example.fromfridgetoplate.guicontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigator {
    private static Navigator navigator = null;
    private static Stage stage;

    private Navigator() {}
    public static Navigator getInstance(Stage newStage){
        if(navigator == null){
            navigator = new Navigator();
            stage = newStage;
        }
        return navigator;
    }
    public void goTo(String fxmlString) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlString)));
        Scene scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    public void setLoginPage(String fxmlString) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlString));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Prova");
        stage.setScene(scene);
        stage.show();
    }

}
