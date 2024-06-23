package edu.uoc.locuocomotive.model;

public class Station {
    public int id;
    public String name;
    public String city;
    public int openingYear;
    public String type;
    public String image;
    public int positionX;
    public int positionY;

    public Station(int id, String name, String city, int openingYear, String type, String image, int positionX, int positionY) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.openingYear = openingYear;
        this.type = type;
        this.image = image;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
