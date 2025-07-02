package com.example.flightdashboard.simulation;

import com.example.flightdashboard.service.FlightData;
import com.example.flightdashboard.service.FlightDataListener;
import java.util.ArrayList;
import java.util.List;
import  java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.example.flightdashboard.data.FlightDataRepository;

public class FlightDataSimulator{

    Random random = new Random();

    private ScheduledExecutorService scheduler;

    private FlightData flightData;
    private List<FlightDataListener> listeners = new ArrayList<>();

    public FlightDataSimulator( FlightData flightData){
        this.flightData = flightData;
    }


    public void start() {
        scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            this.flightData = new FlightData(
                    random.nextDouble() * 10000,
                    random.nextDouble() * 900,
                    random.nextDouble()
            );
            FlightDataRepository.getInstance().setFlightData(this.flightData);
            for (FlightDataListener listener : listeners) {

                listener.onFlightDataUpdate(this.flightData);
            }
        }, 0, 1, TimeUnit.SECONDS);

    }

    public void addFlightDataListener(FlightDataListener listener){
        listeners.add(listener);
    }

    public void stop() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }


}
