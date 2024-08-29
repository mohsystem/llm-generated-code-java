package gtp4o.task183;

import codestral.task183.Task183_MISTRAL_codestral_latest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task183Test {

    private Task183_OPENAI_gpt_4o task;

    @BeforeEach
    void setUp() {
        task = new Task183_OPENAI_gpt_4o();
    }

    @Test
    void testLargestProductBasic() {
        assertEquals(162, Task183_OPENAI_gpt_4o.findLargestProduct("63915", 3));
    }

    @Test
    void testLargestProductSingleDigit() {
        assertEquals(6, Task183_OPENAI_gpt_4o.findLargestProduct("6", 1));
    }

    @Test
    void testLargestProductAllZeros() {
        assertEquals(0, Task183_OPENAI_gpt_4o.findLargestProduct("00000", 3));
    }

    @Test
    void testLargestProductSingleSeries() {
        assertEquals(120, Task183_OPENAI_gpt_4o.findLargestProduct("12345", 5));
    }

    @Test
    void testLargestProductSpanGreaterThanInput() {
        assertEquals(0, Task183_OPENAI_gpt_4o.findLargestProduct("123", 5));
    }

    @Test
    void testLargestProductSpanZero() {
        assertEquals(0, Task183_OPENAI_gpt_4o.findLargestProduct("123456", 0));
    }
    @Test
    void testLargestSeriesProductNoSpan() {
        assertEquals(0, Task183_MISTRAL_codestral_latest.maxProduct("123456", 0));
    }
    @Test
    void testLargestProductInvalidCharacters() {
        assertEquals(30, Task183_OPENAI_gpt_4o.findLargestProduct("123456", 2));
    }

    @Test
    void testLargestProductAllSameDigit() {
        assertEquals(2401, Task183_OPENAI_gpt_4o.findLargestProduct("7777777", 4));
    }

    @Test
    void testLargestProductSpanEqualsInput() {
        assertEquals(5040, Task183_OPENAI_gpt_4o.findLargestProduct("1234567", 7));
    }
}
