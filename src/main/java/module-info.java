module com.example.flightdashboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jdk.jfr;

    opens com.example.flightdashboard.ui to javafx.fxml;

    exports com.example.flightdashboard;
}