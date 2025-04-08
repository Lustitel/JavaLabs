package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    private final StringProcessor stringProcessor = new StringProcessor(); // исправлено

    @Test
    void SP_EmptyString() {
        String res = stringProcessor.StringCopy("", 1);
        assertEquals("", res);
    }

    @Test
    void SP_zeroString() {
        String res = stringProcessor.StringCopy("Skibidi", 0);
        assertEquals("", res);
    }

    @Test
    void SP_positiveNumber() {
        String res = stringProcessor.StringCopy("Skibidi", 3);
        assertEquals("SkibidiSkibidiSkibidi", res);
    }

    @Test
    void SP_negativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> stringProcessor.StringCopy("Skibidi", -1));
    }

    @Test
    void CSIF_NormalCount() {  // исправлено имя метода
        int res = stringProcessor.CountSecondInFirst("Chia seed, Will seed", "seed");
        assertEquals(2, res);
    }

    @Test
    void CSIF_NormalCount2() {  // исправлено имя метода
        int res = stringProcessor.CountSecondInFirst("ababababa", "aba");
        assertEquals(4, res);
    }

    @Test
    void CSIF_SecondIsNull() {
        assertThrows(IllegalArgumentException.class, () -> stringProcessor.CountSecondInFirst("SafeSpace", null));
    }

    @Test
    void CSIF_SecondIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> stringProcessor.CountSecondInFirst("Rizzler", ""));
    }

    @Test
    void CSIF_ZeroCount() {
        int zero_res = stringProcessor.CountSecondInFirst("Hey, bartender!", "Give me some drink");
        assertEquals(0, zero_res);
    }

    @Test
    void SR_NormalReplace() {
        String res_str = stringProcessor.stringReplacer("a1b2c3");
        assertEquals("aодинbдваcтри", res_str);
    }

    @Test
    void SR_No123() {
        String res_str = stringProcessor.stringReplacer("abc");
        assertEquals("abc", res_str);
    }

    @Test
    void SR_EmptyString() {
        String res_str = stringProcessor.stringReplacer("");
        assertEquals("", res_str);
    }

    @Test
    void SR_NullString() {
        assertThrows(IllegalArgumentException.class, () -> stringProcessor.stringReplacer(null));
    }

    @Test
    void SR_OtherNums() {
        String res_str = stringProcessor.stringReplacer("981763");
        assertEquals("98один76три", res_str);
    }

    @Test
    void DS_Normal() {
        StringBuilder sb = new StringBuilder("Hello world!");
        stringProcessor.DeleteSecond(sb);
        assertEquals("Hlowrd", sb.toString());
    }

    @Test
    void DS_EmptyString() {
        StringBuilder sb = new StringBuilder("");
        stringProcessor.DeleteSecond(sb);
        assertEquals("", sb.toString());
    }

    @Test
    void DS_NullString() {
        assertThrows(IllegalArgumentException.class, () -> stringProcessor.DeleteSecond(null));
    }

    @Test
    void DS_OneSymbol() {
        StringBuilder sb = new StringBuilder("1");
        stringProcessor.DeleteSecond(sb);
        assertEquals("1", sb.toString());
    }

    @Test
    void DS_TwoSymbols() {
        StringBuilder sb = new StringBuilder("12");
        stringProcessor.DeleteSecond(sb);
        assertEquals("1", sb.toString());
    }
}