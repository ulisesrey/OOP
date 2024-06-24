package edu.uoc.locuocomotive.model;

import java.time.LocalTime;

public class Ticket {
    private String passport;
    private String routeId;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private double cost;
    private String originStationName;
    private String destinationStationName;
    private String seatType;
    private String seatNumber;

    public Ticket(String Passport, String RouteId, LocalTime DepartureTime, LocalTime ArrivalTime, double Cost, String originStationName, String destinationStationName, String seatType, String seatNumber) {
        this.passport = Passport;
        this.routeId = RouteId;
        this.departureTime = DepartureTime;
        this.arrivalTime = ArrivalTime;
        this.cost = Cost;
        this.originStationName = originStationName;
        this.destinationStationName = destinationStationName;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
    }

public String getPassport(){
        return passport;
    }
    public LocalTime getDepartureTime() {
        return departureTime;
    }
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public String getRouteId() {
        return routeId;
    }
    public String getSeatType() {
        return seatType;
    }
    public double getCost() {
        return cost;
    }

    public String getOriginStation() {
        return originStationName;
    }
    public String getDestinationStation() {
        return destinationStationName;
    }
    public String getSeatNumber() {
        return seatNumber;
    }



    @Override
    public String toString() {
        return routeId + "|" + departureTime + "|" + originStationName +"|" + arrivalTime + "|" + destinationStationName + "|" + seatNumber + "|" + cost; //Car and Seat number missing!
    }
}