package edu.uoc.locuocomotive.model;

public class Station {
    private String id;
    private String name;
    private String city;
    private int openingYear;
    private StationType type;
    private Coordinates coordinates;
    private String imageFilename;

    public Station(String id, String name, String city, int openingYear, StationType type, Coordinates coordinates, String imageFilename) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.openingYear = openingYear;
        this.type = type;
        this.coordinates = coordinates;
        this.imageFilename = imageFilename;
    }

    public String getId() {
        return id;
    }

    // other getters and toString() method
}
