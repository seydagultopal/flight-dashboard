package com.example.flightdashboard.service;

public class FlightData {

    private double altitude;
    private double speed;
    private double fuel;

    public FlightData( double altitude, double speed, double fuel){
        this.altitude = altitude;
        this.speed = speed;
        this.fuel= fuel;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getFuel() {
        return fuel;
    }

    public double getSpeed() {
        return speed;
    }
}
