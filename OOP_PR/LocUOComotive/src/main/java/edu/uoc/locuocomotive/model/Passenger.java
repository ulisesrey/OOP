package edu.uoc.locuocomotive.model;

import java.time.LocalDate;

public class Passenger {
    private String passport;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public Passenger(String passport, String firstName, String lastName, LocalDate birthDate, String email) {
        this.passport = passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    // other getters and methods
}
