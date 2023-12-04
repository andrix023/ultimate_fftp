module com.example.fromfridgetoplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fromfridgetoplate.guicontroller to javafx.fxml;
    exports com.example.fromfridgetoplate.guicontroller;
}