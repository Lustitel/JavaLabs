package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionsDemo {
//TODO: Задание №1
// Вход: список строк и символ.
// Выход: количество строк входного списка, у которых первый символ совпадает с заданным.
    public int counter = 0;
    public int sameNameCounter(ArrayList<String> fullNameList, char surnameSimb)
    {
        if (fullNameList == null || surnameSimb == '\u0000') throw new IllegalArgumentException("Null elements not allowed!");
        else
        {
            for (String el: fullNameList)
            {
                if (el == null || el.isEmpty()) throw new IllegalArgumentException("Empty or null string not allowed!");
                else if (el.charAt(0) == surnameSimb) counter++;
            }
        }
        return counter;
    }

    public static List<Set<Integer>> notSameSets(List<Set<Integer>> setsList, Set<Integer> intSet) {
        //TODO: Задание №4
        // Вход: список множеств целых чисел и еще одно множество.
        // Выход: список всех множеств входного списка, которые не пересекаются с заданным множеством.
        if (setsList.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        } else if (intSet == null || intSet.isEmpty()) {
            throw new IllegalArgumentException("Array is null");
        } else {
            List<Set<Integer>> removeIntersectList = new ArrayList<>();
            boolean intersection = true;
            for (Set<Integer> setFromList : setsList) {
                if(setFromList == null || setFromList.isEmpty()) throw new IllegalArgumentException("Elements in List maybe null or empty!");
                for (Integer el: setFromList){
                    if (intSet.contains(el)){
                        intersection = false;
                        break;
                    } else intersection = true;
                }
                if (intersection) removeIntersectList.add(setFromList);
            }
            return removeIntersectList;
        }
    }
}