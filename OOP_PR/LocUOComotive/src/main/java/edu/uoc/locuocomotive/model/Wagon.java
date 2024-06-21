package edu.uoc.locuocomotive.model;

public class Wagon {
    private String id;
    private WagonClass wagonClass;
    private int totalSeats;
    private int availableSeats;

    public Wagon(String id, int totalSeats) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.wagonClass = determineWagonClass(totalSeats);
    }

    public String getId() {
        return id;
    }

    public WagonClass getWagonClass() {
        return wagonClass;
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

    public static Wagon parseWagon(String id, int totalSeats) {
        return new Wagon(id, totalSeats);
    }
}
