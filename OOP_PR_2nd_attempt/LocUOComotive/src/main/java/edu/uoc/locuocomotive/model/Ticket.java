package edu.uoc.locuocomotive.model;

import java.time.LocalTime;

public class Ticket {
    public String Passport;
    public String RouteId;
    public LocalTime DepartureTime;
    public LocalTime ArrivalTime;
    public double Cost;
    public String originStationName;
    public String destinationStationName;
    public String seatType;

    public String seatNumber;

    public Ticket(String Passport, String RouteId, LocalTime DepartureTime, LocalTime ArrivalTime, double Cost, String originStationName, String destinationStationName, String seatType, String seatNumber) {
        this.Passport = Passport;
        this.RouteId = RouteId;
        this.DepartureTime = DepartureTime;
        this.ArrivalTime = ArrivalTime;
        this.Cost = Cost;
        this.originStationName = originStationName;
        this.destinationStationName = destinationStationName;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
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
        return seatType;
    }
    public double getCost() {
        return Cost;
    }

    public String getOriginStation() {
        return originStationName;
    }
    public String getDestinationStation() {
        return destinationStationName;
    }
    public int getCarNumber() {
        return 0;
    }



    @Override
    public String toString() {
        return RouteId + "|" + DepartureTime + "|" + originStationName +"|" + ArrivalTime + "|" + destinationStationName + "|" + seatNumber + "|" + Cost; //Car and Seat number missing!
    }
}