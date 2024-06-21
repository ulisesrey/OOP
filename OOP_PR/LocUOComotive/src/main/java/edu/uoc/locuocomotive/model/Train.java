package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int id;
    private String trainModel;
    private List<Wagon> wagons;

    public Train(int id, String trainModel, List<Wagon> wagons) {
        this.id = id;
        this.trainModel = trainModel;
        this.wagons = wagons;
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

    public Seat getAvailableSeat(WagonClass wagonClass) {
        for (Wagon wagon : wagons) {
            if (wagon.getWagonClass() == wagonClass && wagon.getAvailableSeats() > 0) {
                // Assuming seats can be represented by numbers, returning the first available seat
                return new Seat(1, SeatType.STANDARD, true); // Placeholder for actual seat logic
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("|").append(trainModel);
        for (Wwagonagon : wagons) {
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
            wagons.add(Wagon.parseWagon("W" + (i - 1), WagonClass.SECOND_CLASS, seatsCount)); // Assuming second class and sequential IDs
        }

        return new Train(id, trainModel, wagons);
    }
}

