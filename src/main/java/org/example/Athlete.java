package org.example;

import java.time.LocalDate;

public class Athlete {
    private String name;
    private LocalDate dob;
    private String country;

    public Athlete(String name, LocalDate dob, String country) {
        this.name = name;
        this.dob = dob;
        this.country = country;
    }

    public Athlete(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+","+dob+","+country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
