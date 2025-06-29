package com.example.flightdashboard.simulation;

import com.example.flightdashboard.service.FlightData;
import com.example.flightdashboard.service.FlightDataListener;
import java.util.ArrayList;
import java.util.List;
import  java.util.Random;

public class FlightDataSimulator{

    Random random = new Random();

    private FlightData flightData;
    private List<FlightDataListener> listeners = new ArrayList<>();

    public FlightDataSimulator( FlightData flightData){
        this.flightData = flightData;
    }


    public void start() {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.flightData = new FlightData(random.nextDouble(), random.nextDouble(), random.nextDouble());
                for (FlightDataListener listener: listeners) {
                    listener.onFlightDataUpdate(this.flightData);
                }
            }
        });
        t1.start();


    }

    public void addFlightDataListener(FlightDataListener listener){
        listeners.add(listener);
    }


}
