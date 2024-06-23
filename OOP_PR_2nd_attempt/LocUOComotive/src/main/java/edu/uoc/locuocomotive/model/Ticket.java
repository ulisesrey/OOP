package edu.uoc.locuocomotive.model;

import java.time.LocalTime;

public class Ticket {
    public String Passport;
    public String RouteId;
    public LocalTime DepartureTime;
    public LocalTime ArrivalTime;
    public double Cost;
    public int originStationId;
    public int destinationStationId;
    public String SeatType;

    public Ticket(String Passport, String RouteId, LocalTime DepartureTime, LocalTime ArrivalTime, double Cost, int originStationId, int destinationStationId, String SeatType) {
        this.Passport = Passport;
        this.RouteId = RouteId;
        this.DepartureTime = DepartureTime;
        this.ArrivalTime = ArrivalTime;
        this.Cost = Cost;
        this.originStationId = originStationId;
        this.destinationStationId = destinationStationId;
        this.SeatType = SeatType;
    }

public String getPassport(){
        return Passport;
    }
    public LocalTime getDepartureTime() {
        return DepartureTime;
    }
    public LocalTime getArrivalTime() {
        return ArrivalTime;
    }
    public String getRouteId() {
        return RouteId;
    }
    public String getSeatType() {
        return SeatType;
    }
    public double getCost() {
        return Cost;
    }

    public int getOriginStationId() {
        return originStationId;
    }
    public int getDestinationStationId() {
        return destinationStationId;
    }
    public int getCarNumber() {
        return 0;
    }
    public int getSeatNumber() {
        return 0;
    }

    @Override
    public String toString() {
        return RouteId + "|" + DepartureTime + "|" + originStationId +"|" + ArrivalTime + "|" + destinationStationId + "|" + Cost; //Car and Seat number missing!
    }
}