package edu.uoc.locuocomotive.model;

import java.time.LocalDateTime;

public class Ticket {
    private Passenger passenger;
    private Seat seat;
    private double price;
    private LocalDateTime departure;
    private LocalDateTime arrival;

    public Ticket(Passenger passenger, Seat seat, double price, LocalDateTime departure, LocalDateTime arrival) {
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
    }

    // getters and methods
}
