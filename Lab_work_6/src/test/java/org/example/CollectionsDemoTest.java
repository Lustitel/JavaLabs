package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class CollectionsDemoTest {
    String s1 = "Игнатьев М. Ю.";
    String s2 = "Шлёпанец А. А.";
    String s3 = "Широков М. С.";
    String strNull = null;
    char ch1 = 'А';
    char chNull = '\u0000';
    char ch2 = 'Ш';
    ArrayList<String> namesList = new ArrayList<>();
    CollectionsDemo demo = new CollectionsDemo();
    int counter = 0;

    @Test
    void normalTest(){
        namesList.add(s1);
        namesList.add(s2);
        namesList.add(s3);

        for(String i: namesList) {if (i.charAt(0) == ch2) counter++;}
        assertEquals(counter, demo.sameNameCounter(namesList, ch2));
    }

    @Test
    void nullInListTest(){
        namesList.add(strNull);
        namesList.add(strNull);
        namesList.add(s1);

        assertThrows(IllegalArgumentException.class, () -> demo.sameNameCounter(namesList, ch1));
    }

    @Test
    void nullCharTest(){
        namesList.add(s1);
        namesList.add(s2);
        namesList.add(s3);

        assertThrows(IllegalArgumentException.class, () -> demo.sameNameCounter(namesList, chNull));
    }

    @Test
    void testNoIntersection() {
        List<Set<Integer>> input = List.of(
                Set.of(1, 2),
                Set.of(3, 4),
                Set.of(5)
        );
        Set<Integer> intSet = Set.of(10, 11);

        List<Set<Integer>> result = CollectionsDemo.notSameSets(input, intSet);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(input)); // всё без пересечений
    }

    @Test
    void testSomeIntersection() {
        List<Set<Integer>> input = List.of(
                Set.of(1, 2),       // пересекается (2)
                Set.of(3, 4),       // не пересекается
                Set.of(5, 6, 7)     // пересекается (6)
        );
        Set<Integer> intSet = Set.of(2, 6);

        List<Set<Integer>> result = CollectionsDemo.notSameSets(input, intSet);

        assertEquals(1, result.size());
        System.out.println(result);
    }

    @Test
    void testAllIntersecting() {
        List<Set<Integer>> input = List.of(
                Set.of(1, 2),
                Set.of(2),
                Set.of(3, 2)
        );
        Set<Integer> intSet = Set.of(2);

        List<Set<Integer>> result = CollectionsDemo.notSameSets(input, intSet);
        assertEquals(0, result.size());
    }

    @Test
    void testEmptyInputList() {
        List<Set<Integer>> input = new ArrayList<>();
        Set<Integer> intSet = Set.of(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> CollectionsDemo.notSameSets(input, intSet));
    }

    @Test
    void testEmptyIntersectionSet() {
        List<Set<Integer>> input = List.of(
                Set.of(1, 2),
                Set.of(3, 4)
        );
        Set<Integer> intSet = Set.of();
        assertThrows(IllegalArgumentException.class, () -> CollectionsDemo.notSameSets(input, intSet));
    }
}