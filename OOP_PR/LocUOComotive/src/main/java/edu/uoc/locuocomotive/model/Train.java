package edu.uoc.locuocomotive.model;

public class Train import java.util.List;

public class Train {
    private String id;
    private String model;
    private List<Wagon> wagons;

    public Train(String id, String model, List<Wagon> wagons) {
        this.id = id;
        this.model = model;
        this.wagons = wagons;
    }

    public String getId() {
        return id;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    // other getters and methods
}
{
}
