package edu.uoc.locuocomotive.model;

public class Seat {
    private int number;
    private Wagon wagon;
    private boolean available;

    public Seat(int number, Wagon wagon, boolean available) {
        this.number = number;
        this.wagon = wagon;
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public SeatType getType() {
        return wagon.getSeatType();
    }

    public boolean isAvailable() {
        return available;
    }
}