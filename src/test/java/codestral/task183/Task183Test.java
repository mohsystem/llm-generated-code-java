package codestral.task183;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task183Test {

    private Task183_MISTRAL_codestral_latest task;

    @BeforeEach
    void setUp() {
        task = new Task183_MISTRAL_codestral_latest();
    }

    @Test
    void testLargestSeriesProductBasic() {
        assertEquals(162, Task183_MISTRAL_codestral_latest.maxProduct("63915", 3));
    }

    @Test
    void testLargestSeriesProductSingleDigit() {
        assertEquals(6, Task183_MISTRAL_codestral_latest.maxProduct("6", 1));
    }

    @Test
    void testLargestSeriesProductAllZeros() {
        assertEquals(0, Task183_MISTRAL_codestral_latest.maxProduct("00000", 3));
    }

    @Test
    void testLargestSeriesProductSingleSeries() {
        assertEquals(120, Task183_MISTRAL_codestral_latest.maxProduct("12345", 5));
    }

    @Test
    void testLargestSeriesProductSpanGreaterThanInput() {
        assertEquals(0, Task183_MISTRAL_codestral_latest.maxProduct("123", 5));
    }

    @Test
    void testLargestSeriesProductSpanZero() {
        assertEquals(0, Task183_MISTRAL_codestral_latest.maxProduct("123456", 0));
    }

    @Test
    void testLargestSeriesProductNoSpan() {
        assertEquals(0, Task183_MISTRAL_codestral_latest.maxProduct("123456", 0));
    }

    @Test
    void testLargestSeriesProductInvalidCharacters() {
        assertEquals(30, Task183_MISTRAL_codestral_latest.maxProduct("123456", 2));
    }

    @Test
    void testLargestSeriesProductAllSameDigit() {
        assertEquals(2401, Task183_MISTRAL_codestral_latest.maxProduct("7777777", 4));
    }

    @Test
    void testLargestSeriesProductSpanEqualsInput() {
        assertEquals(5040, Task183_MISTRAL_codestral_latest.maxProduct("1234567", 7));
    }
}
