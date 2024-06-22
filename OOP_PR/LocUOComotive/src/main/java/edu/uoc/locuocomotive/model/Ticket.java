package edu.uoc.locuocomotive.model;

import java.time.LocalTime;

public class Ticket {
    private Passenger passenger;
    private Seat seat;
    private double price;
    private Schedule schedule; // Changed from departure and arrival Schedule objects to one Schedule object

    public Ticket(Passenger passenger, Seat seat, double price, Schedule schedule) { // Modified constructor
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.schedule = schedule; // Set schedule
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

    public LocalTime getArrivalTime() { // New method to get the Schedule object
        return this.schedule.getArrivalTime();
    }
    public LocalTime getDepartureTime() { // New method to get the Schedule object
        return this.schedule.getDepartureTime();
    }
    public int getDepartureStationId() {
        return this.schedule.getOriginStationId();
    }

    public int getArrivalStationId() {
        return this.schedule.getDestinationStationId();
    }

    public String getCarNumberSeatNumber() {
        return this.seat.getWagonId() + "-" + this.seat.getSeatNumber();
    }

    public double calculatePrice() {
        // Implement price calculation logic here
        return price;
    }
}