package edu.uoc.locuocomotive.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String passport;
    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;

    public Passenger(String passport, String name, String surName, LocalDate birthDate, String email) {
        this.passport = passport;
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        // THis should check for email string to be proper.
        this.email = email;
    }


    @Override
    public String toString() {
        return passport + "|" + name  + "|" + surName + "|" + birthDate +"|"+ email;
    }

}
