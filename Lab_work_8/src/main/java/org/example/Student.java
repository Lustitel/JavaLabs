package org.example;

import java.util.Objects;

public class Student extends Human
{
    String nameFaculty;
    public Student(String first_name, String second_name, String last_name, int age, String nameFaculty) {
        super(first_name, second_name, last_name, age);
        this.nameFaculty = nameFaculty;
    }

    public String getNameFaculty() {return nameFaculty;}

    public void setNameFaculty(String nameFaculty) {this.nameFaculty = nameFaculty;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getNameFaculty(), student.getNameFaculty());
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), getNameFaculty());}

    @Override
    public String toString() {
        return "Student{" +
                "nameFaculty='" + nameFaculty + '\'' +
                '}';
    }
}
