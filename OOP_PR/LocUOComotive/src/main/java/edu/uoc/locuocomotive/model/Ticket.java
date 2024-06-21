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

    private Route route;

    public Route getRoute() {
        return this.route;
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

    public Schedule getArrivalSchedule() {
        return this.arrival;
    }

    public int getArrivalStationId() {
        return this.departure.getStationId();
    }

    public Schedule getDepartureSchedule() {
        return this.departure;
    }

    public int getDepartureStationId() {
        return this.departure.getStationId();
    }

    public Schedule getArrival() {
        return arrival;
    }

    public double calculatePrice() {
        // Implement price calculation logic here
        return price;
    }


}
