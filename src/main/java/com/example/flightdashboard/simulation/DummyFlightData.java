package com.example.flightdashboard.simulation;

import com.example.flightdashboard.service.FlightData;
import javafx.fxml.FXML;

public class DummyFlightData {

    public FlightData getSampleFlightData() {
        return new FlightData(1200.0, 340.0, 0.75);
    }


}
