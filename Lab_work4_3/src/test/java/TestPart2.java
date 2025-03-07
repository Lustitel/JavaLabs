import org.example.part1.*;
import org.example.part2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPart2 {

    @Test
    public void TestSumFunc() {
        step1 test = new step1(2, 3, 0, 10);
        SumFunc<step1> SumFunc_test = new SumFunc<>();
        assertEquals(39.0,
                SumFunc_test.calculate(test),
                0.1,
                "Сумма значений функции должна быть 66.0");
    }

    @Test
    public void TestIntegralFunc() {
        step1 test = new step1(2, 3, 0, 10);
        IntegralFunc<step1> IntegralFunc_test = new IntegralFunc<>(0, 10, 1000);
        assertEquals(
                130.0,
                IntegralFunc_test.calculate(test),
                "Интеграл функции должен быть 130.0"
        );
    }

    @Test
    public void TestIntegralFuncOutOfBounds() {
        step1 test = new step1(2, 3, 5, 15);
        IntegralFunc<step1> IntegralFunc_test = new IntegralFunc<>(0, 10, 1000);
        assertThrows(IllegalArgumentException.class, () ->
                        IntegralFunc_test.calculate(test),
                "Должно быть исключение, если [a; b] не содержится в области определения функции"
        );
    }
}