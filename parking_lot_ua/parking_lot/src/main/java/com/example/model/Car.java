package com.example.model;

/**
 * Model object to represent a Car.
 */
public class Car {
    private String registrationNumber;
    private String color;
    
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getColor() {
        return this.color;
    }

    public Car(final String registrationNumber, final String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}
