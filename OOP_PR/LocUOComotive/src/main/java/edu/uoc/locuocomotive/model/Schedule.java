package edu.uoc.locuocomotive.model;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Schedule {
    private LocalTime departure;
    private LocalTime arrival;
    private int stationId; // Added stationId field

    public Schedule(LocalTime departure, LocalTime arrival, int stationId) { // Modified constructor
        this.departure = departure;
        this.arrival = arrival;
        this.stationId = stationId; // Set stationId
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public List<LocalTime> getTimes() {
        return Arrays.asList(departure, arrival);
    }

    public int getStationId() { // Added getStationId method
        return stationId;
    }
}