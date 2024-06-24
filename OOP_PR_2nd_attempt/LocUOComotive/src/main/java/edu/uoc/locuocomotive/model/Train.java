package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    public int id;
    public String model;
    public int[] cars;
    public List<Wagon> wagons; // = new ArrayList<Wagon>();

    public Train(int id, String model, int[] cars) {
        this.id = id;
        this.model = model;
        this.cars = cars;
        this.wagons = new ArrayList<>();
        createWagons();
    }

    private void createWagons() {
        for (int i = 0; i < cars.length; i++) {
            // Assuming each car in the array corresponds to a wagon with the same index
            // The type of wagon can be determined based on your criteria, here using "Passenger" as default
            Wagon wagon = new Wagon(i + 1, this, cars[i]);
            wagons.add(wagon);
        }
    }

    public Train getTrainById(int id) {
        return this;
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

    public void emptyTrain(){
        List<Wagon> wagons = this.getWagons();
        String seatNumber = null;
        for (Wagon wagon : wagons) {
            // Reset number of available seats to numberOfSeats
            wagon.setAvailableSeats(wagon.getNumberOfSeats());
        }
    }

    @Override
    public String toString() {
        // return id, model and number of cars
        return id + "|" + model + "|" + cars.length;

    }
}
