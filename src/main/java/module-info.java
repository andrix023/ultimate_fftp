module com.example.fromfridgetoplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fromfridgetoplate to javafx.fxml;
    exports com.example.fromfridgetoplate;
}