package org.example;

import java.util.Objects;

public class Human
{
    String firstName, secondName, lastName;
    int age;

    public Human(String firstName, String secondName, String lastName, int age){
            this.age = age;
            this.firstName = firstName;
            this.secondName = secondName;
            this.lastName = lastName;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getSecondName() {return secondName;}

    public void setSecondName(String secondName) {this.secondName = secondName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return age == human.age && Objects.equals(firstName, human.firstName) && Objects.equals(secondName, human.secondName) && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
