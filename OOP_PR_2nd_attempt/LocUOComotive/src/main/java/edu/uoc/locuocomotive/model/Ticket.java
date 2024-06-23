package edu.uoc.locuocomotive.model;

import java.time.LocalTime;

public class Ticket {
    public String Passport;
    public int RouteId;
    public LocalTime DepartureTime;
    public LocalTime ArrivalTime;
    public double Cost;
    public int originStationId;
    public int destinationStationId;
    public String SeatType;

    public Ticket(String Passport, int RouteId, LocalTime DepartureTime, LocalTime ArrivalTime, double Cost, int originStationId, int destinationStationId, String SeatType) {
        this.Passport = Passport;
        this.RouteId = RouteId;
        this.DepartureTime = DepartureTime;
        this.ArrivalTime = ArrivalTime;
        this.Cost = Cost;
        this.originStationId = originStationId;
        this.destinationStationId = destinationStationId;
        this.SeatType = SeatType;
    }
}