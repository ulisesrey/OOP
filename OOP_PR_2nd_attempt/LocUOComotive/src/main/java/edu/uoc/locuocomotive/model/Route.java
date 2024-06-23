package edu.uoc.locuocomotive.model;

public class Route {
    public String id;
    public int trainId;
    public String[] StationsAndTimes;

    public Route(String id, int trainId, String[] StationsAndTimes) {
        this.id = id;
        this.trainId = trainId;
        this.StationsAndTimes = StationsAndTimes;
    }

    public int getDepartureStationId() {
        int stationId = Integer.parseInt(StationsAndTimes[0].split("|")[0]);
        return stationId;
    }
    @Override
    public String toString() {
        return id + "|" +
        trainId + "|" +
        String.join(",", StationsAndTimes);
    }
}
