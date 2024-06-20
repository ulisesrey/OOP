package edu.uoc.locuocomotive.model;

public class Seat {
    private int number;
    private SeatType type;
    private boolean available;

    public Seat(int number, SeatType type, boolean available) {
        this.number = number;
        this.type = type;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    // other getters and methods
}
