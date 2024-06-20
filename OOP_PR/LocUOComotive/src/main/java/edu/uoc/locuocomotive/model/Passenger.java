package edu.uoc.locuocomotive.model;

import java.time.LocalDate;
import java.util.regex.Pattern;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public boolean validateEmail() {
        if (email == null || email.isEmpty()) {
            return true; // Email is optional
        }
        String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
