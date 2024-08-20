package gemini.task10;

import org.junit.jupiter.api.Test;
import static gemini.task10.Solution.getSum;

import static llama3.task10.Task10_PERPLEXITY_llama_3_sonar_large_32k_chat.sumBetween;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task10_TestCase {

    @Test
    void testPositiveRange() {
        // Test with positive numbers where a < b
        assertEquals(3, getSum(1, 2));
    }

    @Test
    void testPositiveRangeReversed() {
        // Test with positive numbers where b < a
        assertEquals(3, getSum(2, 1));
    }

    @Test
    void testSingleNumber() {
        // Test with a single number
        assertEquals(5, getSum(5, 5));
    }

    @Test
    void testZeroInRange() {
        // Test with a range that includes zero
        assertEquals(1, getSum(0, 1));
    }

    @Test
    void testNegativeToPositive() {
        // Test with a range from negative to positive numbers
        assertEquals(2, getSum(-1, 2));
    }

    @Test
    void testNegativeRange() {
        // Test with negative numbers where a < b
        assertEquals(-6, getSum(-3, -1));
    }

    @Test
    void testNegativeRangeReversed() {
        // Test with negative numbers where b < a
        assertEquals(-6, getSum(-1, -3));
    }


    @Test
    void testPositiveAndNegativeRange() {
        // Test with a mix of positive and negative numbers where a < b
        assertEquals(-2, sumBetween(-2, 1));
    }

    @Test
    void testPositiveAndNegativeRangeReversed() {
        // Test with a mix of positive and negative numbers where b < a
        assertEquals(-2, sumBetween(1, -2));
    }

    @Test
    void testLargeRange() {
        // Test with a large range from -100 to 100
        assertEquals(0, sumBetween(-100, 100));
    }
}
