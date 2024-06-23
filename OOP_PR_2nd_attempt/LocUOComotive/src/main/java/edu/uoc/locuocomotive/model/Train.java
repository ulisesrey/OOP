package edu.uoc.locuocomotive.model;

public class Train {
    public int id;
    public String model;
    public int[] cars;

    public Train(int id, String model, int[] cars) {
        this.id = id;
        this.model = model;
        this.cars = cars;
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

    public int[] getCars() {
        return cars;
    }
    @Override
    public String toString() {
        // return id, model and number of cars
        return id + "|" + model + "|" + cars.length;

    }
}
