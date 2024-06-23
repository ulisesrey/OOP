package edu.uoc.locuocomotive.model;
import java.time.LocalDate;

public class Passenger {
    private String passport;
    public String name;
    public String surName;
    public LocalDate birthDate;
    public String email;

    public Passenger(String passport, String name, String surName, LocalDate birthDate, String email) {
        this.passport = passport;
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.email = email;
    }
}
