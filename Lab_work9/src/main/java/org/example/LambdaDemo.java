package org.example;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaDemo {

    //получение длины строки
    public static final Function<String, Integer> stringLength = str -> {
        if (str == null) {
            throw new IllegalArgumentException("Строка не должна быть null");
        }
        return str.length();
    };

    //получение первого символа или null, если не существует
    public static final Function<String, Character> firstSymbol = str -> str != null && !str.isEmpty() ? str.charAt(0): null;


    //проверить что строка не содержит пробелов
    public static final Function<String, Boolean> notSpace = str -> {
        if (str == null) {
            throw new IllegalArgumentException("Строка не должна быть null");
        }
        return  !str.contains(" ");
    };


    //слова в строке разделены запятыми, по строке получить количество слов в ней
    public static final Function<String, Integer> numWords = str -> {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        String[] words = str.split(",");
        return words.length;
    };


    //по человеку получить его возраст
    public static final Function<Human, Integer> ageHuman = human -> {
        if(human == null) {
            throw new IllegalArgumentException(" Human должен быть не null");
        }
        return human.getAge();
    };


    //проверить что у двух людей одинаковая фамилия
    public static final BiPredicate<Human,Human> sameSurname =
            (human1, human2) -> {
                if(human1 == null || human2 == null) {
                    throw new IllegalArgumentException("Оба объекта Human должны быть не null");
                }
                return human1.getSurname().equals(human2.getSurname());
            };


    //получить фамилию, имя и отчество человека в виде одной строки (разделитель - пробел)
    public static final Function<Human, String> fullName = human -> {
        if(human == null) {
            throw new IllegalArgumentException(" Human должен быть не null");
        }
        return human.getName() + " " + human.getPatronymic() + " " + human.getSurname();
    };

    //сделать человека старше на один год (по объекту Human создать новый объект)
    public static final Function<Human,Human> plusOneYear = human -> {
        if(human == null) {
            throw new IllegalArgumentException("Оба объекта Human должны быть не null");
        }
        if(human instanceof Student) {
            Student student = (Student) human;
            return new Student(
                    student.getSurname(),
                    student.getName(),
                    student.getPatronymic(),
                    student.getAge() + 1,
                    student.getGender(),
                    student.getUniversity(),
                    student.getFaculty(),
                    student.getSpeciality()
            );
        } else {
            return new Human(human.getSurname(), human.getName(), human.getPatronymic(),
                    human.getAge() + 1, human.getGender());
        }
    };


    //по трем людям и заданному возрасту maAge проверить, что все три человека моложе maxAge
    public static final MaxAgeFunc<Human, Human, Human, Integer, Boolean> allYoungerThanMaxAge =
            (p1, p2, p3, maxAge) -> {
                if (p1 == null || p2 == null || p3 == null) {
                    throw new IllegalArgumentException("Все объекты Human должны быть не null");
                }
                return  p1.getAge() < maxAge &&
                        p2.getAge() < maxAge &&
                        p3.getAge() < maxAge;
            };
}
