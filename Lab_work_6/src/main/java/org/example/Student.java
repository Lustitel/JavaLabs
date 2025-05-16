package org.example;

public class Student extends Human{
//TODO: Задание №5
// Создайте класс Student, производный от Human,
// новое поле — название факультета, к нему геттер, сеттер и конструктор.
    String faculty;
    public Student(String firstName, String secondName, String lastName, int age, String faculty){
      super(firstName, secondName, lastName, age);
      this.faculty = faculty;
    }

    public String getFaculty() {return faculty;}

    public void setFaculty(String faculty) {this.faculty = faculty;}
}
