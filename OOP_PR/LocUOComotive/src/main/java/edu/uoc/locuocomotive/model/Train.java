package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int id;
    private String train_model;
    private List<Wagon> wagons;

    public Train(int id, String train_model, List<Wagon> wagons) {
        this.id = id;
        this.train_model = train_model;
        this.wagons = wagons;
    }

    public int getId() {
        return id;
    }

    public String getTrainModel() {
        return train_model;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public Seat getAvailableSeat(WagonClass wagonClass) {
        for (Wagon wagon : wagons) {
            if (wagon.getWagonClass() == wagonClass) {
                for (Seat seat : wagon.getSeats()) {
                    if (seat.isAvailable()) {
                        return seat;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("|").append(train_model);
        for (Wagon wagon : wagons) {
            sb.append("|").append(wagon.getSeats().size());
        }
        return sb.toString();
    }

    public static Train parseTrain(String data) {
        String[] parts = data.split("\\|");
        int id = Integer.parseInt(parts[0]);
        String train_model = parts[1];
        List<Wagon> wagons = new ArrayList<>();

        for (int i = 2; i < parts.length; i++) {
            int seatsCount = Integer.parseInt(parts[i]);
            List<Seat> seats = new ArrayList<>();
            for (int j = 0; j < seatsCount; j++) {
                seats.add(new Seat(j + 1, SeatType.STANDARD, true)); // Assuming standard seat type and available by default
            }
            wagons.add(new Wagon("W" + i, WagonClass.SECOND_CLASS, seats, SeatType.STANDARD)); // Assuming second class and standard seat type
        }

        return new Train(id, train_model, wagons);
    }
}

enum WagonClass {
    FIRST_CLASS, SECOND_CLASS
}

enum SeatType {
    STANDARD, PREMIUM
}
