module com.example.gamedataviewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamedataviewer to javafx.fxml;
    exports com.example.gamedataviewer;
}