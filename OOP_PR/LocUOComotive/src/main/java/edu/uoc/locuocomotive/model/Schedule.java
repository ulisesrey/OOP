package edu.uoc.locuocomotive.model;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Schedule {
    private LocalTime departure;
    private LocalTime arrival;
    private int originStationId; // Added originStationId field
    private int destinationStationId; // Added destinationStationId field

    public Schedule(LocalTime departure, LocalTime arrival, int originStationId, int destinationStationId) { // Modified constructor
        this.departure = departure;
        this.arrival = arrival;
        this.originStationId = originStationId; // Set originStationId
        this.destinationStationId = destinationStationId; // Set destinationStationId
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

    public int getOriginStationId() { // Added getOriginStationId method
        return originStationId;
    }

    public int getDestinationStationId() { // Added getDestinationStationId method
        return destinationStationId;
    }
}