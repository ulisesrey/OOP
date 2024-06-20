package edu.uoc.locuocomotive.model;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime departure;
    private LocalDateTime arrival;

    public Schedule(LocalDateTime departure, LocalDateTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }
}

