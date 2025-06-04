package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {
    /*
     Главный метод для демонстрации работы классов и методов ReflectionDemo:
     Создает объекты разных классов: Human, Student (подкласс Human), Warm (не связанный с Human)
     С помощью рефлексии создает список ArrayList и добавляет туда эти объекты динамически.
     Выводит содержимое списка и количество объектов, являющихся экземплярами Human или его подклассов.
     Демонстрирует получение списка открытых методов для объекта типа Warm
     */
    public static void main(String[] args) {
        Human human1 = new Human("Иван", "Иванов", "Иваныч", 25);
        Student student1 = new Student("Василий", "Грекович", "Кириллович", 25, "ФЦТК");
        Warm warm1 = new Warm(100, "Горячий червь");

        ReflectionDemo reflection = new ReflectionDemo();

        Object list = null;
        try {
            list = Class.forName("java.util.ArrayList").getDeclaredConstructor().newInstance();
            Method addMethod = Class.forName("java.util.ArrayList").getMethod("add", Object.class);

            addMethod.invoke(list, human1);
            addMethod.invoke(list, studennt1);
            addMethod.invoke(list, warm1);
        } catch (Exception e) {throw new RuntimeException(e);}
        finally {
            System.out.println(list);
            System.out.println("Кол-во объектов типа Human и его производных: " + reflection.countHumans((List<?>) list));
        }
        System.out.println(reflection.getNameMethods(warm1));
    }

    public int countHumans(List<?> list)
    //TODO: 1.Найдите количество элементов списка, которые являются объектами типа Human или его подтипами.
    {
        int counter = 0;
        for (Object i : list) {if (i instanceof Human) counter++;}
        return counter;
    }

    public List<String> getNameMethods(Object obj)
    //TODO: 2. Для объекта получить список имен его открытых методов.
    {
        List<String> test = new ArrayList<>();
        Method[] methods = obj.getClass().getMethods();
        for (Method i : methods) {test.add(i.getName());}
        return test;
    }

    public List<String> getListSuperClass(Object obj)
    //TODO: 3. Для объекта получить список (в виде списка строк) имен всех его супер классов до Object включительно.
    {
        if (obj == null) throw new IllegalArgumentException();
        List<String> result = new ArrayList<>();

        Class<?> obSuper = obj.getClass();
        while (obSuper != null) {
            result.add(obSuper.getName());
            obSuper = obSuper.getSuperclass();
        }
        return result;
    }
}
