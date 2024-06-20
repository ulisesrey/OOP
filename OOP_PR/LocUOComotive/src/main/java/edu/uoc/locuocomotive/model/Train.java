package edu.uoc.locuocomotive.model;

import java.util.List;

public class Train {
    private int id;
    private String model;
    private List<Wagon> wagons;

    public Train(int id, String model, List<Wagon> wagons) {
        this.id = id;
        this.model = model;
        this.wagons = wagons;
    }
    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public List<Wagon> getWagons() {
        return wagons;
    }
    public Seat getAvailableSeat(WagonClass wagonClass) {
        for (Wagon wagon : wagons) {
            if (wagon.getWagonClass() == wagonClass) {
                for (Seat seat : wagon.getSeats()) {
                    if (seat.isAvailable()) {
                        return seat;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return id + "|" + model + "|" + wagons.size();
    }
}