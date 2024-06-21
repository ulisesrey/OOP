package edu.uoc.locuocomotive.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class Passenger {
    private String passport;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public Passenger(String passport, String firstName, String lastName, LocalDate birthDate, String email) {
        if (passport == null || passport.isEmpty()) {
            throw new IllegalArgumentException("Passport cannot be null or empty");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        if (email != null && !validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.passport = passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return firstName;
    }

    public String getSurname() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void setSurname(String surname) {
        this.lastName = surname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        if (email != null && !validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    private boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return true; // Email is optional
        }
        String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passport='" + passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passport.equals(passenger.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}