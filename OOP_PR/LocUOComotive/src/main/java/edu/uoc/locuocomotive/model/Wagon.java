package edu.uoc.locuocomotive.model;

import java.util.List;


public class Wagon {
    private String id;
    private WagonClass wagonClass;
    private List<Seat> seats;

    public Wagon(String id, WagonClass wagonClass, List<Seat> seats) {
        this.id = id;
        this.wagonClass = wagonClass;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public WagonClass getWagonClass() {
        return wagonClass;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

