package org.example;

public class Student extends Human{

    private String university;
    private String faculty;
    private String speciality;

    public Student(String surname, String name, String patronymic, int age, Gender gender,
                   String university, String faculty, String speciality) {
        super(surname, name, patronymic, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
