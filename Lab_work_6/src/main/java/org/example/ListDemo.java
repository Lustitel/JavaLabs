package org.example;
import java.util.*;

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
    //TODO: Задание №3
    // Вход: список объектов типа Human и еще один объект типа Human. Выход — копия
    // входного списка, не содержащая выделенного человека. При изменении элементов
    // входного списка элементы выходного изменяться не должны.
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
    //TODO: Задание 5
    // Напишите метод класса ListDemo, который получает на вход список, состоящий из
    // объектов типа Human и его производных классов. Результат — множество людей из
    // входного списка с максимальным возрастом.
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

    public static Set<Human> mapHumansIntersectionSet(Map<Integer, Human> mapHumans, Set<Integer> setInteger)
    //TODO: Задание №7
    // Имеется набор людей, каждому человеку задан уникальный целочисленный
    // идентификатор. Напишите метод, который получает на вход отображение (Map)
    // целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    // Результат — множество людей, идентификаторы которых содержатся во входном
    // множестве.
    {
        Set<Human> newSetHuman;
        if (mapHumans.isEmpty()) throw new IllegalArgumentException("Map is empty!");
        else if (setInteger.isEmpty()) throw new IllegalArgumentException("Set in argument is empty!");
        else {
            newSetHuman = new HashSet<>();
            int setKeysIntersection;

            for (Integer integer : setInteger) {
                if (integer == null) throw new NullPointerException("Elements in Set is null!");
                setKeysIntersection = integer;
                if (mapHumans.containsKey(setKeysIntersection)) newSetHuman.add(mapHumans.get(setKeysIntersection));
            }
        }
        return newSetHuman;
    }

    public static List<Integer> mapHumansAverageAge18(Map<Integer, Human> mapHumans)
    //TODO: Задание №8
    // Для отображения из задачи 7 постройте список идентификаторов людей, чей возраст не
    // менее 18 лет.
    {
        List<Integer> newSetHuman = new ArrayList<>();
        if (mapHumans.isEmpty()) throw new IllegalArgumentException("Map is empty!");
        else {
            Integer keyMap;
            Human valueMap;
            for (Map.Entry<Integer, Human> entry : mapHumans.entrySet()) {
                keyMap = entry.getKey();
                if (keyMap == null) throw new NullPointerException("Elements in map is null (Key)");
                valueMap = entry.getValue();
                if (valueMap == null) throw new NullPointerException("Elements in map is null (Value)");
                if (valueMap.getAge() >= 18) newSetHuman.add(keyMap);
            }
        }
        return newSetHuman;
    }

    public static Map<Integer, Integer> mapHumansAgeID(Map<Integer, Human> mapHumans)
    //TODO: Задание №9
    //  Для отображения из задачи 7 постройте новое отображение, которое идентификатору
    //  cопоставляет возраст человека.
    {
        Map<Integer, Integer> newMapHuman = new HashMap<>();
        if (mapHumans.isEmpty()) throw new IllegalArgumentException("Map is null or empty!");
        else {
            Integer keyMap;
            Human valueMap;
            for (Map.Entry<Integer, Human> entry : mapHumans.entrySet()) {
                keyMap = entry.getKey();
                if (keyMap == null) throw new NullPointerException("Elements in map is null (ID)");
                valueMap = entry.getValue();
                if (valueMap == null) throw new NullPointerException("Elements in map is null (Human)");
                newMapHuman.put(keyMap, valueMap.getAge());
            }
        }
        return newMapHuman;
    }

    public static Map<Integer, List<Human>> mapAgeHumansList(Set<Human> setHuman)
    //TODO: Задание №10
    // По множеству объектов типа Human постройте отображение, которое целому числу
    // (возраст человека) сопоставляет список всех людей данного возраста из входного
    // множества.
    {
        Map<Integer, List<Human>> newMapHuman = new TreeMap<>();
        if (setHuman.isEmpty()) throw new IllegalArgumentException("Map is null or empty!");
        else {
            List<Human> listHumans;
            for (Human i : setHuman) {
                if (i == null) throw new NullPointerException("Elements in map is null (Human)");
                else if (newMapHuman.containsKey(i.getAge())) newMapHuman.get(i.getAge()).add(i);
                else {
                    listHumans = new ArrayList<>();
                    listHumans.add(i);
                    newMapHuman.put(i.getAge(), listHumans);
                }
            }
        }
        return newMapHuman;
    }
}
