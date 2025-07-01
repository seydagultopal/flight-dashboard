package com.example.flightdashboard.data;

import com.example.flightdashboard.service.FlightData;

public class FlightDataRepository {
    private static FlightDataRepository instance;

    private FlightData flightData;

    private FlightDataRepository() {}

    public static FlightDataRepository getInstance() {
        if (instance == null) {
            instance = new FlightDataRepository();
        }
        return instance;
    }

    public FlightData getFlightData() {
        return flightData;
    }

    public void setFlightData(FlightData data) {
        this.flightData = data;
    }



}
