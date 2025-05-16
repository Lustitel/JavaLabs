package org.example;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class ListDemo
{
    public List<Human> sameNameList(List<Human> humanList, Human dude){
    //TODO: Задание №2
    // Напишите метода класса ListDemo, который получает на вход список объектов типа Human
    // и еще один объект типа Human. Результат — список однофамильцев заданного человека
    // среди людей из входного списка.
        List<Human> filteredHumanList = new ArrayList<>();
        if (humanList == null || humanList.isEmpty()) throw new IllegalArgumentException("Null or empty list not allowed!");
        if (dude == null || dude.getSecondName().isEmpty()) throw new IllegalArgumentException("Null human or human with no second name not allowed!");
        else
        {
            for (Human el: humanList)
            {
                if (el == null || el.getSecondName().isEmpty()) throw new IllegalArgumentException("Null human not allowed!");
                else{
                    if (el.getSecondName().equals(dude.getSecondName())){
                        filteredHumanList.add(el);
                    }
                }
            }
        }
        return filteredHumanList;
    }

    public List<Human> copyWithoutSelectedList(List<Human> humanList, Human unwanted) {
        if (humanList == null || humanList.isEmpty())
            throw new IllegalArgumentException("Null or empty list not allowed!");
        if (unwanted == null)
            throw new IllegalArgumentException("Null human not allowed!");

        List<Human> excludedHumanList = new ArrayList<>();
        for (Human el : humanList) {
            if (el == null)
                throw new IllegalArgumentException("Null human not allowed!");
            if (!el.equals(unwanted)) {
                Human copy = new Human(el.getFirstName(), el.getSecondName(), el.getLastName(), el.getAge());
                excludedHumanList.add(copy);
            }
        }
        return excludedHumanList;
    }

    public static Set<Human> elderStudentsList(List<? extends Human> studentHumanList){
        Set<Human> resultHumanStudentList = new HashSet<>();
        if (studentHumanList.isEmpty()) throw new IllegalArgumentException("Empty list not allowed!");
        else {
            int maxAge = studentHumanList.getFirst().getAge();
            for (Human i: studentHumanList){
                if (i == null) throw new IllegalArgumentException("Null list elements not allowed!");
                if (i.getAge() > maxAge) maxAge = i.getAge();
            }
            for (Human i: studentHumanList){
                if (i == null) throw new IllegalArgumentException("Null list elements not allowed!");
                if (i.getAge() == maxAge) {
                    resultHumanStudentList.add(new Human(
                            i.getFirstName(),
                            i.getSecondName(),
                            i.getLastName(),
                            i.getAge()));
                }
            }
        }
    return resultHumanStudentList;
    }
}
