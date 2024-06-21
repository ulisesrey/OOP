package edu.uoc.locuocomotive.controller;

import edu.uoc.locuocomotive.model.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class LocUOComotiveController {

    private Model model;

    private List<Station> stations;
    private List<Route> routes;
    private List<Train> trains;
    private Map<String, Passenger> passengers = new HashMap<>();
    private List<Ticket> tickets;

    public LocUOComotiveController(String stationsFile, String routesFile, String trainsFile) {
        this.model = new Model();
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
                Station station = new Station(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        StationType.valueOf(parts[4]),
                        parts[5],
                        Integer.parseInt(parts[6]),
                        Integer.parseInt(parts[7])
                );
                stations.add(station);
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
                Route route = Route.parseRoute(line);
                routes.add(route);
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
                int[] seats = new int[parts.length - 2];
                for (int i = 2; i < parts.length; i++) {
                    seats[i - 2] = Integer.parseInt(parts[i]);
                }
                addTrain(Integer.parseInt(parts[0]), parts[1], seats);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStation(int id, String name, String city, int openingYear, String type, String image, int positionX, int positionY) {
        Station station = new Station(id, name, city, openingYear, StationType.valueOf(type), image, positionX, positionY);
        stations.add(station);
    }

    public void addRoute(String id, int trainId, String... stationsAndTimes) {
        Train train = trains.stream().filter(t -> t.getId() == trainId).findFirst().orElse(null);
        if (train == null) {
            throw new IllegalArgumentException("Train with ID " + trainId + " not found");
        }

        List<Route.StationSchedule> stationSchedules = new ArrayList<>();

        for (String stationAndTime : stationsAndTimes) {
            String[] parts = stationAndTime.split("\\[|\\]|,");
            int stationId = Integer.parseInt(parts[0]);
            String[] times = parts[1].split(",");

            Station station = stations.stream().filter(s -> s.getId() == stationId).findFirst().orElse(null);
            if (station == null) {
                throw new IllegalArgumentException("Station with ID " + stationId + " not found");
            }

            for (String time : times) {
                stationSchedules.add(new Route.StationSchedule(stationId, time, time));
            }
        }

        Route route = new Route(id, trainId, stationSchedules);
        routes.add(route);
    }


    public void addTrain(int id, String model, int... cars) {
        List<Wagon> wagons = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            int seatsCount = cars[i];

            // Create the wagon first
            String wagonId = String.valueOf(id) + "-" + (i + 1);
            Wagon wagon = new Wagon(wagonId, seatsCount);

            List<Seat> seatList = new ArrayList<>();
            WagonClass wagonClass = Wagon.determineWagonClass(seatsCount);
            SeatType seatType = Wagon.determineSeatType(wagonClass);

            for (int j = 0; j < seatsCount; j++) {
                // Pass the wagonId to the Seat constructor
                seatList.add(new Seat(j + 1, seatType, true, wagonId));
            }

            // Add the seats to the wagon
            wagon.setSeats(seatList);

            wagons.add(wagon);
        }
        Train train = new Train(id, model, wagons);
        trains.add(train);
    }

    private Wagon createWagon(int id, int totalSeats) {
        return new Wagon(String.valueOf(id), totalSeats);
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
            for (Route.StationSchedule schedule : route.getStationSchedules()) {
                if (schedule.getStationId() == stationId) {
                    String departureTime = schedule.getDepartureTime();
                    String arrivalTime = schedule.getArrivalTime();
                    String routeId = route.getId();
                    double ticketCost = calculateTicketCost(departureTime, arrivalTime);
                    int departureStationId = schedule.getStationId();
                    int arrivalStationId = route.getDestinationStationId();
                    Station departureStation = findStationById(departureStationId);
                    Station arrivalStation = findStationById(arrivalStationId);

                    String routeInfo = String.format("%s|%s|%s|%.2f|%d|%d|%s|%s",
                            departureTime, arrivalTime, routeId, ticketCost, departureStationId, arrivalStationId,
                            departureStation != null ? departureStation.getName() : "Unknown Station",
                            arrivalStation != null ? arrivalStation.getName() : "Unknown Station");
                    routesInfo.add(routeInfo);
                }
            }
        }
        routesInfo.sort(Comparator.comparing(s -> s.split("\\|")[0]));
        return routesInfo;
    }

    private double calculateTicketCost(String departureTime, String arrivalTime) {
        LocalTime departure = LocalTime.parse(departureTime);
        LocalTime arrival = LocalTime.parse(arrivalTime);
        long hours = ChronoUnit.HOURS.between(departure, arrival);
        return hours * 30.0;
    }

    private Station findStationById(int stationId) {
        return stations.stream()
                .filter(station -> station.getId() == stationId)
                .findFirst()
                .orElse(null);
    }


    public void addPassenger(String passport, String name, String surname, LocalDate birthdate, String email) throws Exception {
        Passenger existingPassenger = passengers.get(passport);
        if (existingPassenger != null) {
            // Update existing passenger's details
            existingPassenger.setName(name);
            existingPassenger.setSurname(surname);
            existingPassenger.setBirthDate(birthdate);
            existingPassenger.setEmail(email);
        } else {
            // Create new passenger and add to map
            Passenger newPassenger = new Passenger(passport, name, surname, birthdate, email);
            passengers.put(passport, newPassenger);
        }
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
        Station originStation = stations.stream().filter(s -> s.getId() == originStationId).findFirst().orElse(null);
        Station destinationStation = stations.stream().filter(s -> s.getId() == destinationStationId).findFirst().orElse(null);
        if (originStation == null || destinationStation == null) {
            throw new Exception("Station does not exist");
        }
        Seat seat = route.getTrain().getAvailableSeat(SeatType.valueOf(selectedSeatType));
        if (seat == null) {
            throw new Exception("No available seats");
        }

        Schedule departureSchedule = new Schedule(departureTime, departureTime);
        Schedule arrivalSchedule = new Schedule(arrivalTime, arrivalTime);
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
            String routeId = ticket.getRoute().getId();
            String departureTime = ticket.getDepartureSchedule().toString();
            String departureStationName = findStationById(ticket.getDepartureStationId()).getName();
            String arrivalTime = ticket.getArrivalSchedule().toString();
            String arrivalStationName = findStationById(ticket.getArrivalStationId()).getName();
            String carNumberSeatNumber = ticket.getSeat().getWagonId() + "-" + ticket.getSeat().getSeatNumber();
            double ticketCost = ticket.calculatePrice();

            String ticketStr = String.format("%s|%s|%s|%s|%s|%s|%.2f",
                    routeId, departureTime, departureStationName, arrivalTime, arrivalStationName, carNumberSeatNumber, ticketCost);
            ticketInfo.add(ticketStr);
        }
        return ticketInfo;
    }

    public String getPassengerInfo(String passport) {
        Passenger passenger = passengers.get(passport);
        if (passenger == null) {
            return "";
        }
        return String.format("%s|%s|%s|%s|%s",
                passenger.getPassport(),
                passenger.getName(),
                passenger.getSurname(),
                passenger.getBirthDate(),
                passenger.getEmail());
    }

    public String getTrainInfo(int trainId) {
        Train train = trains.stream().filter(t -> t.getId() == trainId).findFirst().orElse(null);
        if (train == null) {
            return "";
        }
        return String.format("%d|%s|%d",
                train.getId(),
                train.getTrainModel(),
                train.getWagons().size());
    }

    public List<String> getPassengerTickets(String passport) {
        List<String> passengerTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getPassenger().getPassport().equals(passport)) {
                String routeId = ticket.getRoute().getId();
                String departureTime = ticket.getDepartureSchedule().toString();
                String departureStationName = findStationById(ticket.getDepartureStationId()).getName();
                String arrivalTime = ticket.getArrivalSchedule().toString();
                String arrivalStationName = findStationById(ticket.getArrivalStationId()).getName();
                String carNumberSeatNumber = ticket.getSeat().getWagonId() + "-" + ticket.getSeat().getSeatNumber();
                double ticketCost = ticket.calculatePrice();

                String ticketStr = String.format("%s|%s|%s|%s|%s|%s|%.2f",
                        routeId, departureTime, departureStationName, arrivalTime, arrivalStationName, carNumberSeatNumber, ticketCost);
                passengerTickets.add(ticketStr);
            }
        }
        return passengerTickets;
    }

    public List<String> getRouteDeparturesInfo(String routeId) {
        List<String> departuresInfo = new ArrayList<>();
        Route route = routes.stream().filter(r -> r.getId().equals(routeId)).findFirst().orElse(null);
        if (route != null) {
            for (Route.StationSchedule schedule : route.getStationSchedules()) {
                int stationId = schedule.getStationId();
                List<String> times = schedule.getTimes().stream().map(LocalTime::toString).collect(Collectors.toList());
                String timesStr = String.join(", ", times);
                String scheduleStr = String.format("%d|[%s]", stationId, timesStr);
                departuresInfo.add(scheduleStr);
            }
        }
        return departuresInfo;
    }

    public int getCurrentStationId() {
        if (routes.isEmpty() || routes.get(0).getStations().isEmpty()) {
            return -1; // Indicating no station available
        }
        return routes.get(0).getStations().get(0).getStationId();
    }
}
