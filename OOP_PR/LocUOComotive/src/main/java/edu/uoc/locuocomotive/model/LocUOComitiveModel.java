package edu.uoc.locuocomotive.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private List<Station> stations;
    private List<Route> routes;
    private List<Train> trains;
    private Map<String, Passenger> passengers;
    private List<Ticket> tickets;

    public Model() {
        this.stations = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.trains = new ArrayList<>();
        this.passengers = new HashMap<>();
        this.tickets = new ArrayList<>();
    }

    public void loadStations(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Station station = new Station(
                        values[0],
                        values[1],
                        values[2],
                        Integer.parseInt(values[3]),
                        StationType.valueOf(values[4]),
                        new Coordinates(Double.parseDouble(values[5]), Double.parseDouble(values[6])),
                        values[7]
                );
                stations.add(station);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTrains(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<Wagon> wagons = new ArrayList<>();
                for (String wagonId : values[2].split(";")) {
                    wagons.add(new Wagon(wagonId));
                }
                Train train = new Train(values[0], values[1], wagons);
                trains.add(train);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRoutes(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Train train = trains.stream().filter(t -> t.getId().equals(values[1])).findFirst().orElse(null);
                List<Station> routeStations = new ArrayList<>();
                for (String stationId : values[2].split(";")) {
                    routeStations.add(stations.stream().filter(s -> s.getId().equals(stationId)).findFirst().orElse(null));
                }
                Map<Station, List<Schedule>> schedules = new HashMap<>();
                for (Station station : routeStations) {
                    schedules.put(station, new ArrayList<>());  // Add schedule loading logic if available
                }
                Route route = new Route(values[0], train, routeStations, schedules);
                routes.add(route);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Ticket buyTicket(Passenger passenger, Route route, Schedule schedule, SeatType seatType) {
        Seat seat = getAvailableSeat(route.getTrain(), seatType);
        if (seat != null) {
            double price = calculatePrice(route, seatType);
            Ticket ticket = new Ticket(passenger, seat, price, schedule.getDeparture(), schedule.getArrival());
            tickets.add(ticket);
            return ticket;
        } else {
            throw new RuntimeException("No available seats");
        }
    }

    private Seat getAvailableSeat(Train train, SeatType seatType) {
        for (Wagon wagon : train.getWagons()) {
            if (wagon.getSeatType() == seatType) {
                for (Seat seat : wagon.getSeats()) {
                    if (seat.isAvailable()) {
                        return seat;
                    }
                }
            }
        }
        return null;
    }

    private double calculatePrice(Route route, SeatType seatType) {
        double basePrice = 50.0;
        switch (seatType) {
            case FIRST_CLASS:
                return basePrice * 2;
            case SECOND_CLASS:
                return basePrice * 1.5;
            default:
                return basePrice;
        }
    }
}
