package edu.uoc.locuocomotive.model;

public class Station {
    private int id;
    private String name;
    private String city;
    private int openingYear;
    private StationType type;
    private Coordinates coordinates;
    private String imageFilename;

    public Station(int id, String name, String city, int openingYear, StationType type, Coordinates coordinates, String imageFilename) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.openingYear = openingYear;
        this.type = type;
        this.coordinates = coordinates;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getImageFilename() {
        return imageFilename;
    }
}

//    @Override
//    public String toString() {
//        return "Station{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", city='" + city + '\'' +
//                ", openingYear=" + openingYear +
//                ", type=" + type +
//                ", coordinates=" + coordinates +
//                ", imageFilename='" + imageFilename + '\'' +
//                '}';
//    }
//}
