package edu.uoc.locuocomotive.model;

public class Route {
    public int id;
    public int trainId;
    public String[] StationsAndTimes;

    public Route(int id, int trainId, String[] StationsAndTimes) {
        this.id = id;
        this.trainId = trainId;
        this.StationsAndTimes = StationsAndTimes;
    }
}
