package edu.uoc.locuocomotive.model;

import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;

public class Route {
    private String id;
    private Train train;
    private List<Station> stations;
    private Map<Station, List<Schedule>> schedules;

    public Route(String id, Train train, List<Station> stations, Map<Station, List<Schedule>> schedules) {
        this.id = id;
        this.train = train;
        this.stations = stations;
        this.schedules = schedules;
    }

    public String getId() {
        return id;
    }

    public Train getTrain() {
        return train;
    }

    public List<Station> getStations() {
        return stations;
    }

    public Map<Station, List<Schedule>> getSchedules() {
        return schedules;
    }

    public List<Schedule> getSchedule(Station station) {
        return schedules.get(station);
    }
}
