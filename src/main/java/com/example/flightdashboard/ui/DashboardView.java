package com.example.flightdashboard.ui;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class DashboardView {
    @FXML
    private Slider altitudeSlider;

    @FXML
    private Slider speedSlider;

    @FXML
    private ProgressBar fuelBar;

    @FXML
    private void initialize() {
        altitudeSlider.setValue(12000);
        speedSlider.setValue(800);
        fuelBar.setProgress(0.6);  // %60 yakıt
    }

}
