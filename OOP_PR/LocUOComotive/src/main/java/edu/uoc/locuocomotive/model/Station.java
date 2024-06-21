package edu.uoc.locuocomotive.model;

public class Station {
    private int id;
    private String name;
    private String city;
    private int openingYear;
    private StationType type;
    private double coordinates_x;
    private double coordinates_y;
    private String imageFilename;

    public Station(int id, String name, String city, int openingYear, StationType type, double coordinates_x, double coordinates_y, String imageFilename) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.openingYear = openingYear;
        this.type = type;
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
        this.imageFilename = imageFilename;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getOpeningYear() {
        return openingYear;
    }

    public StationType getType() {
        return type;
    }

    public double getCoordinates_x() {
        return coordinates_x;
    }

    public double getCoordinates_y() {
        return coordinates_y;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + city + "|" + openingYear + "|" + type + "|" + imageFilename + "|" + coordinates_x + "|" + coordinates_y;
    }
}