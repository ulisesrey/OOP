package edu.uoc.locuocomotive.model;

import java.util.List;

public class Wagon {
    private String id;
    private WagonClass wagonClass;
    private List<Seat> seats;
    private SeatType seatType; // Add this field

    public Wagon(String id, WagonClass wagonClass, List<Seat> seats, SeatType seatType) {
        this.id = id;
        this.wagonClass = wagonClass;
        this.seats = seats;
        this.seatType = seatType; // Initialize the field in the constructor
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

    public SeatType getSeatType() { // Add this getter
        return seatType;
    }
}