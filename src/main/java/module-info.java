module com.example.flightdashboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.flightdashboard.ui to javafx.fxml;

    exports com.example.flightdashboard;
}