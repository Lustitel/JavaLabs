package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LambdaDemoTest {

    Human human1 = new Human("Иванов", "Иван", "Иваныч", 25, Gender.MALE);
    Human human2 = new Human("Петрова", "Алекса", "Ивановна", 28, Gender.FEMALE);
    Human human3 = new Human("Иванов", "Петр", "Петрович", 30, Gender.MALE);

    @Test
    void testStringLength() {
        assertEquals(4, LambdaDemo.stringLength.apply("Java"));
        assertThrows(IllegalArgumentException.class, () -> LambdaDemo.stringLength.apply(null));
    }

    @Test
    void testFirstSymbol() {
        assertEquals('J', LambdaDemo.firstSymbol.apply("Java"));
        assertNull(LambdaDemo.firstSymbol.apply(""));
        assertNull(LambdaDemo.firstSymbol.apply(null));
    }

    @Test
    void testNotSpace() {
        assertTrue(LambdaDemo.notSpace.apply("HelloWorld"));
        assertFalse(LambdaDemo.notSpace.apply("Hello World"));
        assertThrows(IllegalArgumentException.class, () -> LambdaDemo.notSpace.apply(null));
    }

    @Test
    void testNumWords() {
        assertEquals(3, LambdaDemo.numWords.apply("one,two,three"));
        assertEquals(1, LambdaDemo.numWords.apply("single"));
        assertEquals(0, LambdaDemo.numWords.apply(""));
        assertEquals(0, LambdaDemo.numWords.apply(null));
    }

    @Test
    void testAgeHuman() {
        assertEquals(25, LambdaDemo.ageHuman.apply(human1));
        assertThrows(IllegalArgumentException.class, () -> LambdaDemo.ageHuman.apply(null));
    }

    @Test
    void testSameSurname() {
        assertTrue(LambdaDemo.sameSurname.test(human1, human3));
        assertFalse(LambdaDemo.sameSurname.test(human1, human2));
        assertThrows(IllegalArgumentException.class, () -> LambdaDemo.sameSurname.test(null, human1));
        assertThrows(IllegalArgumentException.class, () -> LambdaDemo.sameSurname.test(human1, null));
    }

    @Test
    void testFullName() {
        assertEquals("Иван Иваныч Иванов", LambdaDemo.fullName.apply(human1));
        assertThrows(IllegalArgumentException.class, () -> LambdaDemo.fullName.apply(null));
    }

    @Test
    void testPlusOneYear_Human() {
        Human older = LambdaDemo.plusOneYear.apply(human1);
        assertEquals(human1.getAge() + 1, older.getAge());
        assertEquals(human1.getSurname(), older.getSurname());
    }

    @Test
    void testPlusOneYear_Student() {
        Student student = new Student("Смирнов", "Олег", "Валерьевич", 19, Gender.MALE,
                "МГУ", "ФИВТ", "Прикладная математика");
        Human updated = LambdaDemo.plusOneYear.apply(student);
        assertTrue(updated instanceof Student);
        assertEquals(20, updated.getAge());
        assertEquals("Смирнов", updated.getSurname());
    }

    @Test
    void testAllYoungerThanMaxAge() {
        assertTrue(LambdaDemo.allYoungerThanMaxAge.check(human1, human2, human3, 40));
        assertFalse(LambdaDemo.allYoungerThanMaxAge.check(human1, human2, human3, 28));
        assertThrows(IllegalArgumentException.class,
                () -> LambdaDemo.allYoungerThanMaxAge.check(null, human2, human3, 50));
    }
}
