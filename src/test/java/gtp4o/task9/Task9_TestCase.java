package gtp4o.task9;

import org.junit.jupiter.api.Test;

import static gtp4o.task9.Task9_OPENAI_gpt_4o.sumIsOddOrEven;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task9_TestCase {
    @Test
    void testEmptyArray() {
        // Test with an empty array, should be treated as [0]
        assertEquals("even", sumIsOddOrEven(new int[] {}));
    }

    @Test
    void testSinglePositiveOdd() {
        // Test with a single positive odd number
        assertEquals("odd", sumIsOddOrEven(new int[] {7}));
    }

    @Test
    void testSinglePositiveEven() {
        // Test with a single positive even number
        assertEquals("even", sumIsOddOrEven(new int[] {8}));
    }

    @Test
    void testMultiplePositives() {
        // Test with multiple positive numbers whose sum is even
        assertEquals("even", sumIsOddOrEven(new int[] {1, 3, 5, 7}));
    }

    @Test
    void testMultiplePositivesOddSum() {
        // Test with multiple positive numbers whose sum is odd
        assertEquals("odd", sumIsOddOrEven(new int[] {1, 2, 3, 4}));
    }

    @Test
    void testMultipleNegatives() {
        // Test with multiple negative numbers whose sum is even
        assertEquals("even", sumIsOddOrEven(new int[] {-2, -4, -6}));
    }

    @Test
    void testMultipleNegativesOddSum() {
        // Test with multiple negative numbers whose sum is odd
        assertEquals("odd", sumIsOddOrEven(new int[] {-1, -2, -3}));
    }

    @Test
    void testMixedNumbersEvenSum() {
        // Test with a mix of positive and negative numbers whose sum is even
        assertEquals("even", sumIsOddOrEven(new int[] {1, -1, 2, -2}));
    }

    @Test
    void testMixedNumbersOddSum() {
        // Test with a mix of positive and negative numbers whose sum is odd
        assertEquals("odd", sumIsOddOrEven(new int[] {1, -1, 2}));
    }

    @Test
    void testLargeNumbers() {
        // Test with large numbers whose sum is even
        assertEquals("even", sumIsOddOrEven(new int[] {1000000, 2000000, -3000000}));
    }
}