package edu.uoc.locuocomotive.model;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class Ticket {
    private Passenger passenger;
    private Seat seat;
    private double price;
    private Schedule departure;
    private Schedule arrival;

    public Ticket(Passenger passenger, Seat seat, double price, Schedule departure, Schedule arrival) {
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public Schedule getDeparture() {
        return departure;
    }

    public Schedule getArrival() {
        return arrival;
    }

    public double calculatePrice() {
        // Implement price calculation logic here
        return price;
    }
}
