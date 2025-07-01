package com.example.flightdashboard.listener;

import com.example.flightdashboard.service.FlightData;
import com.example.flightdashboard.service.FlightDataListener;

public class ConsoleFlightDataLogger implements FlightDataListener {
    @Override
    public void onFlightDataUpdate(FlightData data) {
        System.out.println("Altitude: " + data.getAltitude() +
                ", Speed: " + data.getSpeed() +
                ", Fuel: " + data.getFuel());
    }
}
