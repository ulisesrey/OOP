package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String id;
    private int trainId;
    private List<StationSchedule> stationSchedules;

    public Route(String id, int trainId, List<StationSchedule> stationSchedules) {
        this.id = id;
        this.trainId = trainId;
        this.stationSchedules = stationSchedules;
    }

    public String getId() {
        return id;
    }

    public int getTrainId() {
        return trainId;
    }

    public List<StationSchedule> getStationSchedules() {
        return stationSchedules;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("|").append(trainId);
        for (StationSchedule schedule : stationSchedules) {
            sb.append("|").append(schedule.toString());
        }
        return sb.toString();
    }

    public static Route parseRoute(String data) {
        String[] parts = data.split("\\|");
        String id = parts[0];
        int trainId = Integer.parseInt(parts[1]);

        List<StationSchedule> stationSchedules = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {
            stationSchedules.add(StationSchedule.parseSchedule(parts[i]));
        }

        return new Route(id, trainId, stationSchedules);
    }

    public static class StationSchedule {
        private int stationId;
        private String arrivalTime;
        private String departureTime;

        public StationSchedule(int stationId, String arrivalTime, String departureTime) {
            this.stationId = stationId;
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

        public int getStationId() {
            return stationId;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        @Override
        public String toString() {
            return stationId + "[" + arrivalTime + "," + departureTime + "]";
        }

        public static StationSchedule parseSchedule(String data) {
            String stationIdStr = data.substring(0, data.indexOf('['));
            int stationId = Integer.parseInt(stationIdStr);

            String times = data.substring(data.indexOf('[') + 1, data.indexOf(']'));
            String[] timeParts = times.split(",");
            String arrivalTime = timeParts[0];
            String departureTime = timeParts[1];

            return new StationSchedule(stationId, arrivalTime, departureTime);
        }
    }
}
