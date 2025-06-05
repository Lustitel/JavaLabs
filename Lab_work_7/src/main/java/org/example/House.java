package org.example;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private Person buildingManager;
    private List<Flat> flats;

    public House() {}

    public House(String cadastralNumber, String address, Person buildingManager, List<Flat> flats) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.buildingManager = buildingManager;
        this.flats = flats;
    }

    public String getCadastralNumber() {return cadastralNumber;}

    public void setCadastralNumber(String cadastralNumber) {this.cadastralNumber = cadastralNumber;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public Person getBuildingManager() {return buildingManager;}

    public void setBuildingManager(Person buildingManager) {this.buildingManager = buildingManager;}

    public List<Flat> getFlats() {return flats;}

    public void setFlats(List<Flat> flats) {this.flats = flats;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralNumber, house.cadastralNumber) &&
                Objects.equals(address, house.address) &&
                Objects.equals(buildingManager, house.buildingManager) &&
                Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {return Objects.hash(cadastralNumber, address, buildingManager, flats);}

    @Override
    public String toString() {
        return "House " + cadastralNumber + " at " + address +
                "\nManager: " + buildingManager +
                "\nFlats: " + flats;
    }
}