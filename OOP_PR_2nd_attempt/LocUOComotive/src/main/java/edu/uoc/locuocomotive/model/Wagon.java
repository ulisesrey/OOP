package edu.uoc.locuocomotive.model;

public class Wagon { // referred as Car too
    public int id;
    public Train train;
    public String wagonClass;
    public int numberOfSeats;
    public int availableSeats; // might not be needed here, might go into Controller

    public Wagon(int id, Train train, int numberOfSeats) {
        this.id = id;
        this.train = train;
        this.numberOfSeats = numberOfSeats;
        this.availableSeats = numberOfSeats;

        if (numberOfSeats < 10) {
            this.wagonClass = "First class";
        } else if (numberOfSeats < 50) {
            this.wagonClass = "Second class";
        } else {
            this.wagonClass = "Third class";
        }
    }

    public int getId() {
        return id;
    }

    public Train getTrain() {
        return train;
    }

    public String getWagonClass() {
        return wagonClass;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}