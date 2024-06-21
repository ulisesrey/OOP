package edu.uoc.locuocomotive.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public List<LocalTime> getTimes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.parse(departureTime, formatter));
        times.add(LocalTime.parse(arrivalTime, formatter));
        return times;
    }
}

