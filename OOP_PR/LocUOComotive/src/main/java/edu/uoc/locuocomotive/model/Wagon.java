package edu.uoc.locuocomotive.model;

import java.util.List;

public class Wagon {
    private String id;
    private SeatType seatType;
    private List<Seat> seats;

    public Wagon(String id, SeatType seatType, List<Seat> seats) {
        this.id = id;
        this.seatType = seatType;
        this.seats = seats;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // other getters and methods
}

