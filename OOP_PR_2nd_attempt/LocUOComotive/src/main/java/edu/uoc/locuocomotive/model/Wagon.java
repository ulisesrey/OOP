package edu.uoc.locuocomotive.model;

public class Wagon { // referred as Car too
    public int id;
    public Train train;
    public String wagonClass;
    public int numberOfSeats;

    public Wagon(int id, Train train, int numberOfSeats) {
        this.id = id;
        this.train = train;
        this.numberOfSeats = numberOfSeats;

        if (numberOfSeats < 10) {
            this.wagonClass = "First class";
        } else if (numberOfSeats < 50) {
            this.wagonClass = "Second class";
        } else {
            this.wagonClass = "Third class";
        }
    }
}