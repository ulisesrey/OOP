package edu.uoc.locuocomotive.model;

public class Station {
    private int id;
    private String name;
    private String city;
    private int openingYear;
    private StationType type;
    private String imageFilename;
    private int coordinates_x;
    private int coordinates_y;


    public Station(int id, String name, String city, int openingYear, StationType type, String imageFilename, int coordinates_x, int coordinates_y) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.openingYear = openingYear;
        this.type = type;
        this.imageFilename = imageFilename;
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
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