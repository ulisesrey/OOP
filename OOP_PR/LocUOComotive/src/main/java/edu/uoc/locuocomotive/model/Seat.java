package edu.uoc.locuocomotive.model;

public class Seat {
    private int number;
    private SeatType seatType;
    private boolean available;
    private String wagonId;

    public Seat(int number, SeatType seatType, boolean available, String wagonId) {
        this.number = number;
        this.seatType = seatType;
        this.available = available;
        this.wagonId = wagonId;
    }

    public int getSeatNumber() {
        return this.number;
    }

    public String getWagonId() {
        return this.wagonId;
    }

    public SeatType getType() {
        return seatType;
    }

    public boolean isAvailable() {
        return available;
    }
}