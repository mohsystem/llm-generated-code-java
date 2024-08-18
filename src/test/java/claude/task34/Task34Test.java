package claude.task34;

import org.junit.jupiter.api.Test;
import static claude.task34.Task34_CLAUDE_claude_3_5_sonnet_20240620.narcissistic;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task34Test {

    @Test
    void testThreeDigitNarcissistic() {
        // 153 is a known 3-digit Narcissistic number
        assertTrue(narcissistic(153));
    }

    @Test
    void testThreeDigitNonNarcissistic() {
        // 123 is not a Narcissistic number
        assertFalse(narcissistic(123));
    }

    @Test
    void testFourDigitNarcissistic() {
        // 1634 is a known 4-digit Narcissistic number
        assertTrue(narcissistic(1634));
    }

    @Test
    void testFourDigitNonNarcissistic() {
        // 1652 is not a Narcissistic number
        assertFalse(narcissistic(1652));
    }

    @Test
    void testSingleDigitNarcissistic() {
        // All single-digit numbers are Narcissistic
        assertTrue(narcissistic(5));
    }

    @Test
    void testLargeNarcissisticNumber() {
        // 9474 is a known 4-digit Narcissistic number
        assertTrue(narcissistic(9474));
    }

    @Test
    void testLargeNonNarcissisticNumber() {
        // 9475 is not a Narcissistic number
        assertFalse(narcissistic(9475));
    }

    @Test
    void testFiveDigitNarcissistic() {
        // 54748 is a known 5-digit Narcissistic number
        assertTrue(narcissistic(54748));
    }

    @Test
    void testFiveDigitNonNarcissistic() {
        // 12345 is not a Narcissistic number
        assertFalse(narcissistic(12345));
    }

    @Test
    void testEdgeCaseSingleDigitOne() {
        // 1 is a Narcissistic number
        assertTrue(narcissistic(1));
    }
}
