package edu.uoc.locuocomotive.model;

public class Seat {
    private int number;
    private SeatType seatType;
    private boolean available;

    public Seat(int number, SeatType seatType, boolean available) {
        this.number = number;
        this.seatType = seatType;
        this.available = available;
    }

    public int getSeatNumber() {
        return this.number;
    }

    public String getWagonId() {
        return this.seat.getWagonId();
    }

    public SeatType getType() {
        return seatType;
    }

    public boolean isAvailable() {
        return available;
    }
}