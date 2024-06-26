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

    public void addStation(Station station) {
        this.stations.add(station);
    }
    public void loadStations(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Station station = new Station(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        Integer.parseInt(values[3]),
                        StationType.valueOf(values[4]),
                        values[5], // filename
                        Integer.parseInt(values[6]), // x coordinate
                        Integer.parseInt(values[7])  // y coordinate
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
                Train train = Train.parseTrain(line);
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
                Route route = Route.parseRoute(line);
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
            Ticket ticket = new Ticket(passenger, seat, price, schedule); // Pass schedule directly
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
