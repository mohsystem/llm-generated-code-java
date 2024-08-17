package codestral.task16;

import org.junit.jupiter.api.Test;

import static codestral.task16.Task16_MISTRAL_codestral_latest.solution;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task16_TestCase {

    @Test
    void testBasicTrue() {
        // Test where the first string ends with the second string
        assertTrue(solution("abc", "bc"));
    }

    @Test
    void testBasicFalse() {
        // Test where the first string does not end with the second string
        assertFalse(solution("abc", "d"));
    }

    @Test
    void testEmptyEnding() {
        // Test where the ending string is empty
        assertTrue(solution("abc", ""));
    }

    @Test
    void testEmptyString() {
        // Test where the main string is empty
        assertFalse(solution("", "a"));
    }

    @Test
    void testEndingIsMainString() {
        // Test where the ending string is the same as the main string
        assertTrue(solution("hello", "hello"));
    }

    @Test
    void testEndingLongerThanMainString() {
        // Test where the ending string is longer than the main string
        assertFalse(solution("short", "longerEnding"));
    }

    @Test
    void testEndingAtStart() {
        // Test where the ending string appears at the start of the main string
        assertFalse(solution("startmiddleend", "start"));
    }

    @Test
    void testEndingIsSubstring() {
        // Test where the ending string is a substring but not at the end
        assertFalse(solution("substring", "str"));
    }

    @Test
    void testCaseSensitiveEnding() {
        // Test case sensitivity by checking a lowercase ending in an uppercase string
        assertFalse(solution("HELLO", "hello"));
    }

    @Test
    void testMultipleOccurrences() {
        // Test with multiple occurrences of the ending string in the main string
        assertTrue(solution("testtesttest", "test"));
    }
}
