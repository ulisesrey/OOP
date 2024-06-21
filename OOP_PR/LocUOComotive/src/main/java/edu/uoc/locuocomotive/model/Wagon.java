package edu.uoc.locuocomotive.model;

import java.util.List;

public class Wagon {

    private String id;
    private final List<Seat> seatList;
    private WagonClass wagonClass;
    private SeatType seatType;

    public Wagon(String wagonId, WagonClass wagonClass, List<Seat> seatList, SeatType seatType) {
        this.id = wagonId;
        this.seatList = seatList;
        this.wagonClass = determineWagonClass(wagonClass);
        this.seatType = determineSeatType(this.wagonClass);
    }

    public String getId() {
        return id;
    }

    public WagonClass getWagonClass() {
        return wagonClass;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return id + "|" + wagonClass + "|" + totalSeats + "|" + availableSeats;
    }

    private static WagonClass determineWagonClass(int totalSeats) {
        if (totalSeats < 20) {
            return WagonClass.FIRST_CLASS;
        } else if (totalSeats < 50) {
            return WagonClass.SECOND_CLASS;
        } else {
            return WagonClass.THIRD_CLASS;
        }
    }

    private static SeatType determineSeatType(WagonClass wagonClass) {
        switch (wagonClass) {
            case FIRST_CLASS:
                return SeatType.FIRST_CLASS;
            case SECOND_CLASS:
                return SeatType.SECOND_CLASS;
            case THIRD_CLASS:
                return SeatType.THIRD_CLASS;
            default:
                return SeatType.SECOND_CLASS; // Default to second class if undefined
        }
    }

    public static Wagon parseWagon(String id, int totalSeats) {
        return new Wagon(id, totalSeats);
    }
}