package edu.uoc.locuocomotive.model;

import java.time.LocalTime;

public class Schedule {
    private LocalTime departure;
    private LocalTime arrival;

    public Schedule(LocalTime departure, LocalTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }
}

