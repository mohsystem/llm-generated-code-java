package gemini.task9;

import claude.task9.Task9_CLAUDE_claude_3_5_sonnet_20240620;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static gemini.task9.Solution.oddOrEven;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task9_TestCase {
    @Test
    void testEmptyArray() {
        // Test with an empty array, should be treated as [0]
        assertEquals("even", oddOrEven(Arrays.asList(new Integer[] {})));
    }

    @Test
    void testSinglePositiveOdd() {
        // Test with a single positive odd number
        assertEquals("odd", oddOrEven(Arrays.asList(new Integer[] {7})));
    }

    @Test
    void testSinglePositiveEven() {
        // Test with a single positive even number
        assertEquals("even", oddOrEven(Arrays.asList(new Integer[] {8})));
    }

    @Test
    void testMultiplePositives() {
        // Test with multiple positive numbers whose sum is even
        assertEquals("even", oddOrEven(Arrays.asList(new Integer[] {1, 3, 5, 7})));
    }


    @Test
    void testMultiplePositivesOddSum() {
        // Test with multiple positive numbers whose sum is odd
        assertEquals("even", Task9_CLAUDE_claude_3_5_sonnet_20240620.oddOrEven(new int[] {1, 2, 3, 4}));
    }

    @Test
    void testMultipleNegatives() {
        // Test with multiple negative numbers whose sum is even
        assertEquals("even", Task9_CLAUDE_claude_3_5_sonnet_20240620.oddOrEven(new int[] {-2, -4, -6}));
    }

    @Test
    void testMultipleNegativesOddSum() {
        // Test with multiple negative numbers whose sum is odd
        assertEquals("even", Task9_CLAUDE_claude_3_5_sonnet_20240620.oddOrEven(new int[] {-1, -2, -3}));
    }

    @Test
    void testMixedNumbersEvenSum() {
        // Test with a mix of positive and negative numbers whose sum is even
        assertEquals("even", Task9_CLAUDE_claude_3_5_sonnet_20240620.oddOrEven(new int[] {1, -1, 2, -2}));
    }

    @Test
    void testMixedNumbersOddSum() {
        // Test with a mix of positive and negative numbers whose sum is odd
        assertEquals("even", Task9_CLAUDE_claude_3_5_sonnet_20240620.oddOrEven(new int[] {1, -1, 2}));
    }

    @Test
    void testLargeNumbers() {
        // Test with large numbers whose sum is even
        assertEquals("even", Task9_CLAUDE_claude_3_5_sonnet_20240620.oddOrEven(new int[] {1000000, 2000000, -3000000}));
    }
}