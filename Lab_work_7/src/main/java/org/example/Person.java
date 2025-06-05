package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;

    public Person() {}

    public Person(String lastName, String firstName, String middleName, String birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getMiddleName() {return middleName;}

    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public String getBirthDate() {return birthDate;}

    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {return Objects.hash(lastName, firstName, middleName, birthDate);}

    @Override
    public String toString() {return lastName + " " + firstName + " " + middleName + " (" + birthDate + ")";}
}