package gtp4o.task34;

import org.junit.jupiter.api.Test;

import static gtp4o.task34.Task34_OPENAI_gpt_4o.isNarcissistic;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task34Test {

    @Test
    void testThreeDigitNarcissistic() {
        // 153 is a known 3-digit Narcissistic number
        assertTrue(isNarcissistic(153));
    }

    @Test
    void testThreeDigitNonNarcissistic() {
        // 123 is not a Narcissistic number
        assertFalse(isNarcissistic(123));
    }

    @Test
    void testFourDigitNarcissistic() {
        // 1634 is a known 4-digit Narcissistic number
        assertTrue(isNarcissistic(1634));
    }

    @Test
    void testFourDigitNonNarcissistic() {
        // 1652 is not a Narcissistic number
        assertFalse(isNarcissistic(1652));
    }

    @Test
    void testSingleDigitNarcissistic() {
        // All single-digit numbers are Narcissistic
        assertTrue(isNarcissistic(5));
    }

    @Test
    void testLargeNarcissisticNumber() {
        // 9474 is a known 4-digit Narcissistic number
        assertTrue(isNarcissistic(9474));
    }

    @Test
    void testLargeNonNarcissisticNumber() {
        // 9475 is not a Narcissistic number
        assertFalse(isNarcissistic(9475));
    }

    @Test
    void testFiveDigitNarcissistic() {
        // 54748 is a known 5-digit Narcissistic number
        assertTrue(isNarcissistic(54748));
    }

    @Test
    void testFiveDigitNonNarcissistic() {
        // 12345 is not a Narcissistic number
        assertFalse(isNarcissistic(12345));
    }

    @Test
    void testEdgeCaseSingleDigitOne() {
        // 1 is a Narcissistic number
        assertTrue(isNarcissistic(1));
    }
}
