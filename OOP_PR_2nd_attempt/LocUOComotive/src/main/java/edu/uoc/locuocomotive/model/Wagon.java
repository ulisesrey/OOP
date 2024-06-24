package edu.uoc.locuocomotive.model;

public class Wagon {
    ; // referred as Car too
    private int id;
    private Train train;
    private String wagonClass;
    private int numberOfSeats;
    private int availableSeats;
    private final String FirstAvailableSeat;
    private boolean restaurant;


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

    public void setId(int id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }



    public String getWagonClass() {
        return wagonClass;
    }
    public void setWagonClass(String wagonClass) {
        this.wagonClass = wagonClass;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean isRestaurant(){
        return restaurant;
    }
    public String getFirstAvailableSeat(){
        return "C" + this.getId() + "-" + (this.getNumberOfSeats() - this.getAvailableSeats()+1);
    }

    public void decreaseAvailableSeats() {
        if (this.availableSeats > 0) {
            this.availableSeats--;
        } else {
            throw new IllegalStateException("No available seats left in this wagon.");
        }
    }
}