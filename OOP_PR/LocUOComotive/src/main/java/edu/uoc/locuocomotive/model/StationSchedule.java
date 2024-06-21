package edu.uoc.locuocomotive.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.util.stream.Collectors;

public class StationSchedule {
    private int stationId;
    private List<Schedule> schedules;

    public StationSchedule(int stationId, List<Schedule> schedules) {
        this.stationId = stationId;
        this.schedules = schedules;
    }

    public List<LocalTime> getTimes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.parse(departureTime, formatter));
        times.add(LocalTime.parse(arrivalTime, formatter));
        return times;
    }

    public int getStationId() {
        return this.stationId;
    }

    public List<Schedule> getSchedules() {
        return this.schedules;
    }
}