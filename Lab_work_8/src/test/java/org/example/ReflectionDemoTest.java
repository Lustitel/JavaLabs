package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    ReflectionDemo demo = new ReflectionDemo();
    Object obj = new Object();

    @Test
    void testCountHumans() {
        List<Object> objects = new ArrayList<>();

        Human h = new Human("Иван", "Иванов", "Иваныч", 30);
        Student s = new Student("Мария", "Петрова", "Александровна", 22, "ФЦТК");
        Warm w = new Warm(3, "Червь морозится");

        objects.add(h);
        objects.add(s);
        objects.add(w);

        int result = demo.countHumans(objects);
        assertEquals(2, result);
    }

    @Test
    void testGetNameMethods_Human() {
        Human h = new Human("Иван", "Иванов", "Иваныч", 30);
        List<String> methods = demo.getNameMethods(h);

        assertTrue(methods.contains("getFirstName"));
        assertTrue(methods.contains("toString"));
        assertTrue(methods.contains("hashCode"));
    }

    @Test
    void testGetNameMethods_Warm() {
        Warm w = new Warm(20.5, "Червь кайфует");
        List<String> methods = demo.getNameMethods(w);

        assertTrue(methods.contains("getTemperature"));
        assertTrue(methods.contains("getDescription"));
    }

    @Test
    void testGetListSuperClass_Student() {
        Student s = new Student("Мария", "Петрова", "Александровна", 22, "ФЦТК");

        List<String> test = new ArrayList<>();
        test.add(s.getClass().getName());
        test.add(s.getClass().getSuperclass().getName());
        test.add(obj.getClass().getName());

        List<String> actual = demo.getListSuperClass(s);

        assertEquals(test, actual);
    }

    @Test
    void testGetListSuperClass_Warm() {
        Warm w = new Warm(30.0, "Червь вспотел");

        List<String> hierarchy = demo.getListSuperClass(w);

        assertEquals("org.example.Warm", hierarchy.get(0));
        assertEquals("java.lang.Object", hierarchy.get(1));
    }

    @Test
    void testGetListSuperClass_Null() {
        assertThrows(IllegalArgumentException.class, () -> demo.getListSuperClass(null));
    }
}
