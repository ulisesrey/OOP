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

    public void setName(String name) {
        this.name = name;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        // THis should check for email string to be proper.
        this.email = email;

//    public String getPassport() {
//        return passport;
//    }
//
//    // Write the setters
//    public String setName() {
//        this.name = name;}
//    public String setSurname() {
//        this.surName = surName;}
//    }
//    public LocalDate setBirthDate() {
//        this.birthDate = birthDate;}
//    }
//    public String setEmail() {
//        this.email = email;}
//    }

}
