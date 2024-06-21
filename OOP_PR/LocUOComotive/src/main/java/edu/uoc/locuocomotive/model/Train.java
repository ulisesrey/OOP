package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Train {
    private int id;
    private String trainModel;
    private List<Wagon> wagons;

    // Static map to hold all train instances
    private static Map<Integer, Train> trainRegistry = new HashMap<>();

    public Train(int id, String trainModel, List<Wagon> wagons) {
        this.id = id;
        this.trainModel = trainModel;
        this.wagons = wagons;
        registerTrain(this); // Register the train when it is created
    }

    public int getId() {
        return id;
    }

    public String getTrainModel() {
        return trainModel;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("|").append(trainModel);
        for (Wagon wagon : wagons) {
            sb.append("|").append(wagon.getTotalSeats());
        }
        return sb.toString();
    }

    public static Train parseTrain(String data) {
        String[] parts = data.split("\\|");
        int id = Integer.parseInt(parts[0]);
        String trainModel = parts[1];
        List<Wagon> wagons = new ArrayList<>();

        for (int i = 2; i < parts.length; i++) {
            int seatsCount = Integer.parseInt(parts[i]);
            wagons.add(Wagon.parseWagon("W" + (i - 1), seatsCount));
        }

        return new Train(id, trainModel, wagons);
    }

    // Static method to register a train
    private static void registerTrain(Train train) {
        trainRegistry.put(train.getId(), train);
    }

    // Static method to get a train by ID
    public static Train getTrainById(int id) {
        return trainRegistry.get(id);
    }

    public Seat getAvailableSeat(SeatType seatType) {
        for (Wagon wagon : wagons) {
            for (Seat seat : wagon.getSeats()) {
                if (seat.getType() == seatType && seat.isAvailable()) {
                    return seat;
                }
            }
        }
        return null; // No available seat of the requested type was found
    }
}
