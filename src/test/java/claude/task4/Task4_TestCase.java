package claude.task4;

import org.junit.jupiter.api.Test;

import static claude.task4.Task4_CLAUDE_claude_3_5_sonnet_20240620.isIsogram;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task4_TestCase {

    @Test
    void testCase1() {
        assertTrue(isIsogram("Dermatoglyphics"));  // Basic isogram test
    }

    @Test
    void testCase2() {
        assertFalse(isIsogram("aba"));  // Repeating letter
    }

    @Test
    void testCase3() {
        assertFalse(isIsogram("moOse"));  // Case-insensitive repeating letter
    }

    @Test
    void testCase4() {
        assertTrue(isIsogram("isogram"));  // All lowercase isogram
    }

    @Test
    void testCase5() {
        assertTrue(isIsogram("Machine"));  // Mixed case isogram
    }

    @Test
    void testCase6() {
        assertTrue(isIsogram(""));  // Edge case: Empty string
    }

    @Test
    void testCase7() {
        assertFalse(isIsogram("letter"));  // Consecutive repeating letter
    }

    @Test
    void testCase8() {
        assertFalse(isIsogram("Bookkeeper"));  // Multiple repeating letters
    }

    @Test
    void testCase9() {
        assertFalse(isIsogram("Alphabet"));  // No repeating letters, mixed case
    }

    @Test
    void testCase10() {
        assertFalse(isIsogram("a-c"));  // Edge case: String with hyphen
    }
}