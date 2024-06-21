package edu.uoc.locuocomotive.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    public List<StationSchedule> getStations() {
        return this.stationSchedules;
    }

    public int getTrainId() {
        return trainId;
    }

    public Train getTrain() {
        return Train.getTrainById(this.trainId);
    }

    public List<StationSchedule> getStationSchedules() {
        return stationSchedules;
    }

    public int getDestinationStationId() {
        return stationSchedules.get(stationSchedules.size() - 1).getStationId();
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
        String[] trainAndStations = parts[1].split("=");
        int trainId = Integer.parseInt(trainAndStations[0]);

        List<StationSchedule> stationSchedules = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            stationSchedules.add(StationSchedule.parseSchedule(parts[i]));
        }

        return new Route(id, trainId, stationSchedules);
    }

    public static class StationSchedule {
        private int stationId;
        private String departureTime;
        private String arrivalTime;

        public StationSchedule(int stationId, String departureTime, String arrivalTime) {
            this.stationId = stationId;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
        }

        public int getStationId() {
            return stationId;
        }

        public int getId() {
            return this.stationId;
        }

        public int getTrainId() {
            return trainId;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public List<LocalTime> getTimes() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            List<LocalTime> times = new ArrayList<>();
            times.add(LocalTime.parse(departureTime, formatter));
            times.add(LocalTime.parse(arrivalTime, formatter));
            return times;
        }

        @Override
        public String toString() {
            return stationId + "[" + departureTime + "," + arrivalTime + "]";
        }

        public static StationSchedule parseSchedule(String data) {
            String stationIdStr = data.substring(0, data.indexOf('['));
            int stationId = Integer.parseInt(stationIdStr);

            String times = data.substring(data.indexOf('[') + 1, data.indexOf(']'));
            String[] timeParts = times.split(",");
            String departureTime = timeParts[0];
            String arrivalTime = timeParts[1];

            return new StationSchedule(stationId, departureTime, arrivalTime);
        }
    }
}
