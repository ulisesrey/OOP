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
}
