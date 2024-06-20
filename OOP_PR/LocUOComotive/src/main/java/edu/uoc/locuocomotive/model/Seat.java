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

    public int getNumber() {
        return number;
    }

    public SeatType getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }
}

