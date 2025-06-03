package org.example;

public class Warm {
    private double temperature;
    private String description;

    public Warm(double temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Warm{" +
                "temperature=" + temperature +
                ", description='" + description + '\'' +
                '}';
    }
}
