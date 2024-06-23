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


    public String getId() {
        return id;
    }

    public int getTrainId() {
        return trainId;
    }

    public String[] getStationsAndTimes() {
        return StationsAndTimes;
    }
    public int[] getDepartureStationIds(){
        int[] stationIds = new int[StationsAndTimes.length];
        for (int i = 0; i < StationsAndTimes.length; i++) {
            stationIds[i] = Integer.parseInt(StationsAndTimes[i].split("|")[0]);
        }
        return stationIds;
    }
    public int getFirstDepartureStationId() {
        int stationId = Integer.parseInt(StationsAndTimes[0].split("|")[0]);
        return stationId;
    }

    public int getLastDestinationStationId() { // Not sure this works.
        int stationId =Integer.parseInt(StationsAndTimes[0].split("|")[-1]);
        return stationId;
    }
    @Override
    public String toString() {
        return id + "|" +
        trainId + "|" +
        String.join(",", StationsAndTimes);
    }
}
