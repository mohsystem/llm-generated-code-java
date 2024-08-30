package llama3.task26;

import org.junit.jupiter.api.Test;

import static llama3.task26.Task26_PERPLEXITY_llama_3_sonar_large_32k_chat.findOdd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task26_TestCase {

    @Test
    void testSingleElement() {
        // Test with a single element which should be the result
        assertEquals(7, findOdd(new int[]{7}));
    }

    @Test
    void testSingleZero() {
        // Test with a single zero
        assertEquals(0, findOdd(new int[]{0}));
    }

    @Test
    void testOddOccurrence() {
        // Test with multiple elements where one appears an odd number of times
        assertEquals(2, findOdd(new int[]{1, 1, 2}));
    }

    @Test
    void testMultipleOccurrencesOfOdd() {
        // Test with an element that appears odd number of times
        assertEquals(0, findOdd(new int[]{0, 1, 0, 1, 0}));
    }

    @Test
    void testLargeArrayWithSingleOddOccurrence() {
        // Test with a large array where one element appears an odd number of times
        assertEquals(4, findOdd(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));
    }

    @Test
    void testNegativeNumbers() {
        // Test with negative numbers
        assertEquals(-3, findOdd(new int[]{-1, -1, -2, -2, -3}));
    }

    @Test
    void testAllOddOccurrences() {
        // Test where each number appears an odd number of times
        assertEquals(5, findOdd(new int[]{5, 5, 5, 7, 7, 7,7, 9, 9}));
    }

    @Test
    void testAllEvenOccurrences() {
        // Test where all numbers appear an even number of times
        assertEquals(10, findOdd(new int[]{7, 7, 8, 8, 9, 9, 10}));
    }

    @Test
    void testRepeatedElementAtEnd() {
        // Test with an element that repeats at the end
        assertEquals(9, findOdd(new int[]{1, 1, 2, 2, 3, 3, 9, 9, 9}));
    }

    @Test
    void testMultipleElementsWithOneOdd() {
        // Test with multiple elements where only one element appears an odd number of times
        assertEquals(5, findOdd(new int[]{2, 2, 3, 3, 4, 4, 5, 5, 5}));
    }
}
