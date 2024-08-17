package codestral.task11;

import org.junit.jupiter.api.Test;

import static codestral.task11.Task11_MISTRAL_codestral_latest.nbYear;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11_TestCase {
    @Test
    void testLargePopulationIncrease() {
        // Test with a large initial population and growth, smaller increment
        assertEquals(15, nbYear(1500, 5, 100, 5000));
    }

    @Test
    void testSmallPercentLargeAugmentation() {
        // Test with a small growth percentage and large augmentation
        assertEquals(10, nbYear(1500000, 2.5, 10000, 2000000));
    }

    @Test
    void testZeroPercentGrowth() {
        // Test with zero percent growth but positive annual augmentation
        assertEquals(5, nbYear(1000, 0, 100, 1500));
    }

    @Test
    void testNoAugmentation() {
        // Test with a non-zero percent growth but no annual augmentation
        assertEquals(11, nbYear(1000, 10, 0, 3000));
    }

    @Test
    void testExactPopulationMatch() {
        // Test where the population exactly matches the target population in one year
        assertEquals(1, nbYear(1000, 20, 100, 1200));
    }

    @Test
    void testMinimumInputValues() {
        // Test with minimum positive values
        assertEquals(1, nbYear(1, 1, 1, 2));
    }

    @Test
    void testHighPercentLowAugmentation() {
        // Test with high growth percentage and low augmentation
        assertEquals(4, nbYear(100, 50, 1, 500));
    }

    @Test
    void testHighAugmentationLowPercent() {
        // Test with high annual augmentation and low growth percentage
        assertEquals(5, nbYear(100, 1, 100, 600));
    }

    @Test
    void testLargeInitialPopulation() {
        // Test with a large initial population and small target population
        assertEquals(0, nbYear(1000000, 1, 1, 500000));
    }

    @Test
    void testNegativePercent() {
        // Test with a negative percent value, should handle as 0 percent effectively
        assertEquals(10, nbYear(1000, -2, 50, 1200));
    }
}
