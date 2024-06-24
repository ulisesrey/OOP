package edu.uoc.locuocomotive.model;

public class Route {
    private String id;
    private int trainId;
    private String[] StationsAndTimes;

    public Route(String id, int trainId, String[] StationsAndTimes) {
        this.id = id;
        this.trainId = trainId;
        this.StationsAndTimes = StationsAndTimes;
    }


    public String getId() {
        return id;
    }

    public int getTrainId() {
        return trainId;
    }

    public String[] getStationsAndTimes() {

        return StationsAndTimes;
    }
    public int getFirstDepartureStationId() {
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
