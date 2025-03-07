import org.example.part1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPart1 {

    @Test
    public void TestStep1() {
        step1 f = new step1(2, 3, 0, 10);
        assertEquals(
                5.0,
                f.evaluate(1),
                "f(1) должно быть 2 * 1 + 3 = 5.0"
        );
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        f.evaluate(-1),
                "x вне границ"
        );
    }

    @Test
    public void TestStep2() {
        step2 f = new step2(2, Math.PI, 0, 1);
        assertEquals(
                0.0,
                f.evaluate(0),
                "f(0) должно быть 2sin(0) = 0");
    }

    @Test
    public void TestStep3() {
        step3 f = new step3(1, 2, 3, 4, 0, 10);
        assertEquals(
                0.5,
                f.evaluate(0),
                "f(0) должно быть (1*0 + 2) / (3*0 + 4) = 0.5");
    }

    @Test
    public void TestStep4() {
        step4 f = new step4(2, 3, 0, 1);
        assertEquals(
                5.0,
                f.evaluate(0),
                "f(0) должно быть 2exp(0) + 3 = 5.0"
        );
    }
}