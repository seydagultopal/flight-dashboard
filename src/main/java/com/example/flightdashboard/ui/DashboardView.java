package com.example.flightdashboard.ui;

import com.example.flightdashboard.data.FlightDataRepository;
import com.example.flightdashboard.listener.ConsoleFlightDataLogger;
import com.example.flightdashboard.service.FlightData;
import com.example.flightdashboard.service.FlightDataListener;
import com.example.flightdashboard.simulation.FlightDataSimulator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class DashboardView implements FlightDataListener {
    @FXML
    private Slider altitudeSlider;

    @FXML
    private Slider speedSlider;

    @FXML
    private ProgressBar fuelBar;

    private FlightDataSimulator simulator;

    @FXML
    private void onStartSimulation() {
        simulator.start();
    }

    @FXML
    private void onStopSimulation() {
        simulator.stop();
    }

    @FXML
    private void onEmergencyLanding() {
        FlightData data = new FlightData(
                500.0, // Düşük irtifa
                200.0, // Düşük hız
                FlightDataRepository.getInstance().getFlightData().getFuel()
        );
        FlightDataRepository.getInstance().setFlightData(data);
        onFlightDataUpdate(data);
    }

    @FXML
    private void onShutDownEngine() {
        FlightData data = new FlightData(
                0.0, // Sıfır irtifa
                0.0, // Sıfır hız
                FlightDataRepository.getInstance().getFlightData().getFuel()
        );
        FlightDataRepository.getInstance().setFlightData(data);
        onFlightDataUpdate(data);
    }

    @FXML
    private void initialize() {
        altitudeSlider.setValue(0);
        speedSlider.setValue(0);
        fuelBar.setProgress(0);
        FlightData data = FlightDataRepository.getInstance().getFlightData();
        if (data != null) {
            altitudeSlider.setValue(data.getAltitude());
            speedSlider.setValue(data.getSpeed());
            fuelBar.setProgress(data.getFuel());
        }

        simulator = new FlightDataSimulator(new FlightData(0, 0, 0));
        simulator.addFlightDataListener(this); // DashboardView listener
        simulator.addFlightDataListener(new ConsoleFlightDataLogger()); // Konsola yazan listener
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
