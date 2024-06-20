package edu.uoc.locuocomotive.controller;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class LocUOComotiveController {

    //TODO: Define the attributes

    public LocUOComotiveController(String stationsFile, String routesFile, String trainsFile) {
        //TODO: Implement the constructor
    }

    private void loadStations(String stationsFile) {
        // Get the file from the resources folder
        InputStream is = getClass().getResourceAsStream("/data/" + stationsFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + stationsFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Create the station and add it to the list of stations
                addStation(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRoutes(String routesFile) {
        // Get the file from the resources folder
        InputStream is = getClass().getResourceAsStream("/data/" + routesFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + routesFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by character :
                String[] parts = line.split("=");
                String[] parts2 = parts[0].split("\\|");

                // Create the route and add it to the list of routes
                addRoute(parts2[0], Integer.parseInt(parts2[1]), parts[1].split("\\|"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTrains(String trainsFile) {
        // Get the file from the resources folder
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

                addTrain(Integer.parseInt(parts[0]), parts[1], seatsPerCar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStation(int id, String name, String city, int openingYear, String type, String image, int positionX, int positionY) {
        //TODO
    }

    public void addRoute(String id, int trainId, String... stationsAndTimes) {
        //TODO
    }

    public void addTrain(int id, String model, int... cars) {
        //TODO
    }

    public List<String> getStationsInfo() {
        //TODO
    }

    public String[] getSeatTypes() {
        //TODO
    }

    public List<String> getRoutesByStation(int stationId) {
        //TODO
    }

    public void addPassenger(String passport, String name, String surname, LocalDate birthdate, String email) throws Exception {
        //TODO
    }

    public void createTicket(String passport, String routeId, LocalTime departureTime, LocalTime arrivalTime, double cost, int originStationId, int destinationStationId, String selectedSeatType) throws Exception {
        //TODO
    }

    public void buyTicket(String passport, String name, String surname, LocalDate birthdate, String email,
                            String routeId, LocalTime departureTime, LocalTime arrivalTime, double cost, int originStationId, int destinationStationId, String selectedSeatType) throws Exception {
        //TODO
    }

    public List<String> getAllTickets() {
        //TODO
    }

    public String getPassengerInfo(String passport) {
        //TODO
    }

    public String getTrainInfo(int trainId) {
        //TODO
    }

    public List<String> getPassengerTickets(String passport) {
        //TODO
    }

    public List<String> getRouteDeparturesInfo(String routeId) {
        //TODO
    }

    public int getCurrentStationId() {
        //TODO
    }

}