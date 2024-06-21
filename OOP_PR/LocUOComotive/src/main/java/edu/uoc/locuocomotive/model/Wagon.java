package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
    private String id;
    private WagonClass wagonClass;
    private int totalSeats;
    private int availableSeats;

    public Wagon(String id, WagonClass wagonClass, int totalSeats, int availableSeats) {
        this.id = id;
        this.wagonClass = wagonClass;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
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

    public static Wagon parseWagon(String id, WagonClass wagonClass, int totalSeats) {
        int availableSeats = totalSeats; // Assuming all seats are available initially
        return new Wagon(id, wagonClass, totalSeats, availableSeats);
    }
}
