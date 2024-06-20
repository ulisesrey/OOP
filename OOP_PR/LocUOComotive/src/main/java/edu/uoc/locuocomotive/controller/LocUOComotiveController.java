package edu.uoc.locuocomotive.controller;

import edu.uoc.locuocomotive.model.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class LocUOComotiveController {

    private List<Station> stations;
    private List<Route> routes;
    private List<Train> trains;
    private Map<String, Passenger> passengers;
    private List<Ticket> tickets;

    public LocUOComotiveController(String stationsFile, String routesFile, String trainsFile) {
        this.stations = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.trains = new ArrayList<>();
        this.passengers = new HashMap<>();
        this.tickets = new ArrayList<>();
        loadStations(stationsFile);
        loadRoutes(routesFile);
        loadTrains(trainsFile);
    }

    private void loadStations(String stationsFile) {
        InputStream is = getClass().getResourceAsStream("/data/" + stationsFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + stationsFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                addStation(String.valueOf(Integer.parseInt(parts[0])), parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRoutes(String routesFile) {
        InputStream is = getClass().getResourceAsStream("/data/" + routesFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + routesFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                String[] parts2 = parts[0].split("\\|");
                addRoute(parts2[0], Integer.parseInt(parts2[1]), parts[1].split("\\|"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTrains(String trainsFile) {
        InputStream is = getClass().getResourceAsStream("/data/" + trainsFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + trainsFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int[] seatsPerCar = new int[parts.length - 2];
                for (int i = 2; i < parts.length; i++) {
                    seatsPerCar[i - 2] = Integer.parseInt(parts[i]);
                }
                // Assume all seats are of the same type for now
                SeatType seatType = SeatType.FIRST_CLASS; // Replace with actual SeatType if available
                addTrain(Integer.parseInt(parts[0]), parts[1], seatType, seatsPerCar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStation(String id, String name, String city, int openingYear, String type, String image, int positionX, int positionY) {
        Station station = new Station(id, name, city, openingYear, StationType.valueOf(type), new Coordinates(positionX, positionY), image);
        stations.add(station);
    }

    public void addRoute(String id, int trainId, String... stationsAndTimes) {
        Train train = trains.stream().filter(t -> t.getId() == trainId).findFirst().orElse(null);
        List<Station> routeStations = new ArrayList<>();
        Map<Station, List<Schedule>> schedules = new HashMap<>();
        LocalDate currentDate = LocalDate.now(); // Use the current date or a specific date if available

        for (String stationAndTime : stationsAndTimes) {
            String[] parts = stationAndTime.split(":");
            Station station = stations.stream().filter(s -> s.getId().equals(String.valueOf(Integer.parseInt(parts[0])))).findFirst().orElse(null);
            if (station != null) {
                routeStations.add(station);
                List<Schedule> scheduleList = schedules.getOrDefault(station, new ArrayList<>());
                LocalTime time = LocalTime.parse(parts[1]);
                LocalDateTime dateTime = LocalDateTime.of(currentDate, time);
                scheduleList.add(new Schedule(dateTime, dateTime)); // Use the same dateTime for both departure and arrival for now
                schedules.put(station, scheduleList);
            }
        }

        Route route = new Route(id, train, routeStations, schedules);
        routes.add(route);
    }

    public void addTrain(int id, String model, SeatType seatType, int... cars) {
        List<Wagon> wagons = new ArrayList<>();
        for (int seats : cars) {
            List<Seat> seatList = new ArrayList<>();
            for (int i = 0; i < seats; i++) {
                seatList.add(new Seat(i, seatType, true)); // Use the provided SeatType
            }
            wagons.add(new Wagon(String.valueOf(id), WagonClass.THIRD_CLASS, seatList, seatType)); // Pass SeatType to Wagon constructor
        }
        Train train = new Train(id, model, wagons); // Pass id directly
        trains.add(train);
    }

    public List<String> getStationsInfo() {
        List<String> info = new ArrayList<>();
        for (Station station : stations) {
            info.add(station.toString());
        }
        return info;
    }

    public String[] getSeatTypes() {
        return Arrays.stream(SeatType.values()).map(Enum::name).toArray(String[]::new);
    }

    public List<String> getRoutesByStation(int stationId) {
        List<String> routesInfo = new ArrayList<>();
        for (Route route : routes) {
            for (Station station : route.getStations()) {
                if (station.getId().equals(String.valueOf(stationId))) {
                    routesInfo.add(route.toString());
                }
            }
        }
        return routesInfo;
    }

    public void addPassenger(String passport, String name, String surname, LocalDate birthdate, String email) throws Exception {
        if (passengers.containsKey(passport)) {
            throw new Exception("Passenger already exists");
        }
        Passenger passenger = new Passenger(passport, name, surname, birthdate, email);
        passengers.put(passport, passenger);
    }

    public void createTicket(String passport, String routeId, LocalTime departureTime, LocalTime arrivalTime, double cost, int originStationId, int destinationStationId, String selectedSeatType) throws Exception {
        Passenger passenger = passengers.get(passport);
        if (passenger == null) {
            throw new Exception("Passenger does not exist");
        }
        Route route = routes.stream().filter(r -> r.getId().equals(routeId)).findFirst().orElse(null);
        if (route == null) {
            throw new Exception("Route does not exist");
        }
        Station originStation = stations.stream().filter(s -> s.getId().equals(String.valueOf(originStationId))).findFirst().orElse(null);
        Station destinationStation = stations.stream().filter(s -> s.getId().equals(String.valueOf(destinationStationId))).findFirst().orElse(null);
        if (originStation == null || destinationStation == null) {
            throw new Exception("Station does not exist");
        }
        Seat seat = route.getTrain().getAvailableSeat(WagonClass.valueOf(selectedSeatType));
        if (seat == null) {
            throw new Exception("No available seats");
        }
        LocalDate currentDate = LocalDate.now();
        LocalDateTime departureDateTime = LocalDateTime.of(currentDate, departureTime);
        LocalDateTime arrivalDateTime = LocalDateTime.of(currentDate, arrivalTime);
        Schedule departureSchedule = new Schedule(departureDateTime, departureDateTime);
        Schedule arrivalSchedule = new Schedule(arrivalDateTime, arrivalDateTime);
        Ticket ticket = new Ticket(passenger, seat, cost, departureSchedule, arrivalSchedule);
        tickets.add(ticket);
    }

    public void buyTicket(String passport, String name, String surname, LocalDate birthdate, String email,
                          String routeId, LocalTime departureTime, LocalTime arrivalTime, double cost, int originStationId, int destinationStationId, String selectedSeatType) throws Exception {
        addPassenger(passport, name, surname, birthdate, email);
        createTicket(passport, routeId, departureTime, arrivalTime, cost, originStationId, destinationStationId, selectedSeatType);
    }

    public List<String> getAllTickets() {
        List<String> ticketInfo = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketInfo.add(ticket.toString());
        }
        return ticketInfo;
    }

    public String getPassengerInfo(String passport) {
        Passenger passenger = passengers.get(passport);
        if (passenger == null) {
            return "Passenger does not exist";
        }
        return passenger.toString();
    }

    public String getTrainInfo(int trainId) {
        Train train = trains.stream().filter(t -> t.getId() == trainId).findFirst().orElse(null);
        if (train == null) {
            return "Train does not exist";
        }
        return train.toString();
    }

    public List<String> getPassengerTickets(String passport) {
        List<String> passengerTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getPassenger().getPassport().equals(passport)) {
                passengerTickets.add(ticket.toString());
            }
        }
        return passengerTickets;
    }

    public List<String> getRouteDeparturesInfo(String routeId) {
        List<String> departuresInfo = new ArrayList<>();
        Route route = routes.stream().filter(r -> r.getId().equals(routeId)).findFirst().orElse(null);
        if (route != null) {
            for (Map.Entry<Station, List<Schedule>> entry : route.getSchedules().entrySet()) {
                for (Schedule schedule : entry.getValue()) {
                    departuresInfo.add("Station: " + entry.getKey().getName() + ", Departure: " + schedule.getDeparture().toString());
                }
            }
        }
        return departuresInfo;
    }

    public int getCurrentStationId() {
        if (routes.isEmpty() || routes.get(0).getStations().isEmpty()) {
            return -1; // Indicating no station available
        }
        return Integer.parseInt(routes.get(0).getStations().get(0).getId());
    }
}
