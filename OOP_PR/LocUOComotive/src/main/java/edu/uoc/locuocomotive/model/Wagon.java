package edu.uoc.locuocomotive.model;

import java.util.List;

public class Wagon {
    private String id;
    private final List<Seat> seatList;
    private WagonClass wagonClass;
    private SeatType seatType;

    public Wagon(String wagonId, int totalSeats) {
        this.id = wagonId;
        this.seatList = createSeats(totalSeats);
        this.wagonClass = determineWagonClass(totalSeats);
        this.seatType = determineSeatType(this.wagonClass);
    }

    public String getId() {
        return id;
    }

    public WagonClass getWagonClass() {
        return wagonClass;
    }

    public int getTotalSeats() {
        return seatList.size();
    }

    public int getAvailableSeats() {
        // Assuming all seats are available initially
        return (int) seatList.stream().filter(Seat::isAvailable).count();
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    @Override
    public String toString() {
        return id + "|" + wagonClass + "|" + seatList.size() + "|" + getAvailableSeats();
    }

    public static WagonClass determineWagonClass(int totalSeats) {
        if (totalSeats < 10) {
            return WagonClass.FIRST_CLASS;
        } else if (totalSeats > 50) {
            return WagonClass.THIRD_CLASS;
        } else {
            return WagonClass.SECOND_CLASS;
        }
    }

    public static SeatType determineSeatType(WagonClass wagonClass) {
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

    private List<Seat> createSeats(int totalSeats) {
        List<Seat> seats = new ArrayList<>();
        SeatType seatType = determineSeatType(determineWagonClass(totalSeats));
        for (int i = 0; i < totalSeats; i++) {
            seats.add(new Seat(i + 1, seatType, true));
        }
        return seats;
    }

    public static Wagon parseWagon(String id, int totalSeats) {
        return new Wagon(id, totalSeats);
    }

    public void setSeats(List<Seat> seatList) {
    }
}
