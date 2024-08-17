package claude.task20;

import org.junit.jupiter.api.Test;
import static claude.task20.Task20_CLAUDE_claude_3_5_sonnet_20240620.digPow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task20_TestCase {

    @Test
    void testBasicExample1() {
        // Test with example where n = 89 and p = 1
        assertEquals(1, digPow(89, 1));
    }

    @Test
    void testBasicExample2() {
        // Test with example where n = 92 and p = 1
        assertEquals(-1, digPow(92, 1));
    }

    @Test
    void testBasicExample3() {
        // Test with example where n = 695 and p = 2
        assertEquals(2, digPow(695, 2));
    }

    @Test
    void testNoSolution() {
        // Test where no k exists for the given n and p
        assertEquals(-1, digPow(123, 2));
    }

    @Test
    void testSingleDigit() {
        // Test with a single digit number n = 5 and p = 1
        assertEquals(1, digPow(5, 1));
    }

    @Test
    void testConsecutivePowers() {
        // Test with consecutive powers where n = 135 and p = 1
        assertEquals(1, digPow(135, 1));
    }

    @Test
    void testLargerValue() {
        // Test with larger values where n = 1000 and p = 2
        assertEquals(-1, digPow(1000, 2));
    }

    @Test
    void testAnotherExample() {
        // Test with another example where n = 135 and p = 2
        assertEquals(1, digPow(135, 2));
    }

    @Test
    void testAllDigitsSame() {
        // Test where all digits are the same n = 111 and p = 1
        assertEquals(-1, digPow(111, 1));
    }

    @Test
    void testLeadingZeros() {
        // Test where input includes leading zeros, although not typical, should handle gracefully
        assertEquals(-1, digPow(100, 1));
    }
}
