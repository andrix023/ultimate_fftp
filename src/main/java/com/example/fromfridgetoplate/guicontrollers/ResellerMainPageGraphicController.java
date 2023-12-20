package com.example.fromfridgetoplate.guicontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


    public class ResellerMainPageGraphicController {
        @FXML
        private ImageView pendingOrdersImg;

        @FXML
        private StackPane stackpaneId; // questo contiene pendingOrdersImg

        @FXML
        private StackPane stackpaneId2; // questo contiene viewStatusImg

        @FXML
        private ImageView viewStatusImg;

        @FXML
        void onViewOrdersClicked(MouseEvent event) {
            try {
                // Carica il file FXML per la nuova scena
                FXMLLoader loader = new FXMLLoader(getClass().getResource("viewPendingOrders.fxml"));
                Parent newRoot = loader.load(); // Carica il nuovo nodo radice

                // Ottiene lo Stage corrente dall'evento, cioè aver cliccato il bottone
                Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();

                // Imposta la nuova scena sullo Stage
                Scene newScene = new Scene(newRoot);
                currentStage.setScene(newScene);
                currentStage.show();
            } catch (Exception e) {
                e.printStackTrace();
                // Gestire l'eccezione, ad esempio mostrando un messaggio di errore
            }
        }

        @FXML
        void onViewStatusClicked(MouseEvent event) {
            // Logica esistente per il click
        }

        @FXML // bo?
        void zoom(MouseEvent event) {
            // Logica per lo zoom (se necessaria)
        }

        // Metodi per gestire l'ingrandimento e il cambio di colore del bordo, quando il mouse passa sopra le imageview
        //
        @FXML
        void onMouseEnteredForStackPane1(MouseEvent event) {
            //pendingOrdersImg.setScaleX(1.05);
            //pendingOrdersImg.setScaleY(1.05);
            stackpaneId.setScaleX(1.05);
            stackpaneId.setScaleY(1.05);
            stackpaneId.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-border-style: solid;");
        }

        @FXML
        void onMouseExitedForStackPane1(MouseEvent event) {
            //pendingOrdersImg.setScaleX(1.0);
            //pendingOrdersImg.setScaleY(1.0);
            stackpaneId.setScaleX(1.0); // Reimposta la scala del StackPane
            stackpaneId.setScaleY(1.0);
            stackpaneId.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");
        }

        @FXML
        void onMouseEnteredForStackPane2(MouseEvent event) {
            //viewStatusImg.setScaleX(1.05);
            //viewStatusImg.setScaleY(1.05);
            stackpaneId2.setScaleX(1.05);
            stackpaneId2.setScaleY(1.05);
            stackpaneId2.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-border-style: solid;");
        }

        @FXML
        void onMouseExitedForStackPane2(MouseEvent event) {
            //viewStatusImg.setScaleX(1.0);
            //viewStatusImg.setScaleY(1.0);
            stackpaneId2.setScaleX(1.0);
            stackpaneId2.setScaleY(1.0);
            stackpaneId2.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-style: solid;");
        }
    }

