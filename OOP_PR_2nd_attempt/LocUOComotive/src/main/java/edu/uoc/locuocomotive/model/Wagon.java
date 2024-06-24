package edu.uoc.locuocomotive.model;

public class Wagon {
    ; // referred as Car too
    public int id;
    public Train train;
    public String wagonClass;
    public int numberOfSeats;
    public int availableSeats; // might not be needed here, might go into Controller
    private final String FirstAvailableSeat;

    public boolean restaurant;


    public Wagon(int id, Train train, int numberOfSeats) {
        this.id = id;
        this.train = train;
        this.numberOfSeats = numberOfSeats;
        this.availableSeats = numberOfSeats;

        if (numberOfSeats < 20) {
            this.wagonClass = "FIRST_CLASS";
        } else if (numberOfSeats < 50) {
            this.wagonClass = "SECOND_CLASS";
        } else {
            this.wagonClass = "THIRD_CLASS";
        }
        this.FirstAvailableSeat = getFirstAvailableSeat();

        this.restaurant = (numberOfSeats == 0);
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

    public int AvailableSeats() {
        return availableSeats;
    }

    public boolean isRestaurant(){
        return restaurant;
    }
    public String getFirstAvailableSeat(){
        return "C" + this.getId() + "-" + (this.getNumberOfSeats() - this.AvailableSeats()+1);
    }

    public void decreaseAvailableSeats() {
        if (this.availableSeats > 0) {
            this.availableSeats--;
        } else {
            throw new IllegalStateException("No available seats left in this wagon.");
        }
    }
}