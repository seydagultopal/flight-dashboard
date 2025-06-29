package com.example.flightdashboard.ui;

import com.example.flightdashboard.service.FlightData;
import com.example.flightdashboard.service.FlightDataListener;
import com.example.flightdashboard.simulation.DummyFlightData;
import com.example.flightdashboard.simulation.FlightDataSimulator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class DashboardView implements FlightDataListener {
    @FXML
    private Slider altitudeSlider;

    @FXML
    private Slider speedSlider;

    @FXML
    private ProgressBar fuelBar;

    private FlightDataSimulator simulator;

    @FXML
    private void initialize() {
        altitudeSlider.setValue(0);
        speedSlider.setValue(0);
        fuelBar.setProgress(0);

        simulator = new FlightDataSimulator(new FlightData(0, 0, 0));
        simulator.addFlightDataListener(this);
        simulator.start();
    }

    @Override
    public void onFlightDataUpdate(FlightData data) {
        Platform.runLater(() -> {
            altitudeSlider.setValue(data.getAltitude());
            speedSlider.setValue(data.getSpeed());
            fuelBar.setProgress(data.getFuel());
        });
    }
}
