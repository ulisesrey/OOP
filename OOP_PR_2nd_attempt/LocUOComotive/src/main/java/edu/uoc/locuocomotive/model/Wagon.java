package edu.uoc.locuocomotive.model;

public class Wagon { // referred as Car too
    public int id;
    public Train train;
    public String wagonClass;
    public int numberOfSeats;
    public int availableSeats;

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

    public void buyTicket() {
        if (availableSeats > 0) {
            availableSeats = availableSeats - 1;
        } else {
            throw new IllegalStateException("No available seats in this wagon");
        }
    }
}