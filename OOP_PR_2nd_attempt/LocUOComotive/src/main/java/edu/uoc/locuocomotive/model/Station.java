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
    public int setId(int id) {
        return this.id = id;
    }
    public String setName(String name) {
        return this.name = name;
    }
    public String setCity(String city) {
        return this.city = city;
    }
    public int setOpeningYear(int openingYear) {
        return this.openingYear = openingYear;
    }
    public String setType(String type) {
        return this.type = type;
    }
    public String setImage(String image) {
        return this.image = image;
    }
    public int setPositionX(int positionX) {
        return this.positionX = positionX;
    }
    public int setPositionY(int positionY) {
        return this.positionY = positionY;
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getCity() {
        return this.city;
    }
    public int getOpeningYear() {
        return this.openingYear;
    }
    public String getType() {
        return this.type;
    }
    public String getImage() {
        return this.image;
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public String toString() {
        return id + "|" +
                name + "|" +
                city + "|" +
//                openingYear + "|" +
//                type + "|" +
                image + "|" +
                positionX + "|" +
                positionY;
    }
}
