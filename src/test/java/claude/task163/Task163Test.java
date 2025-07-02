package claude.task163;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task163Test {

    @Test
    @DisplayName("Null array should return 0")
    void testNullArray() {
        assertEquals(0, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(null));
    }

    @Test
    @DisplayName("Empty array should return 0")
    void testEmptyArray() {
        assertEquals(0, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{}));
    }

    @Test
    @DisplayName("Single element array should return 1")
    void testSingleElement() {
        assertEquals(1, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{42}));
    }

    @Test
    @DisplayName("No consecutive runs should return 1")
    void testNoConsecutiveRuns() {
        assertEquals(1, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{3, 5, 7, 10}));
    }

    @Test
    @DisplayName("Strictly increasing sequence")
    void testIncreasingRun() {
        assertEquals(4, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{1, 2, 3, 4}));
    }

    @Test
    @DisplayName("Strictly decreasing sequence")
    void testDecreasingRun() {
        assertEquals(4, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{4, 3, 2, 1}));
    }

    @Test
    @DisplayName("Switching direction still consecutive")
    void testSwitchingDirection() {
        assertEquals(5, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{1, 2, 3, 2, 1}));
    }

    @Test
    @DisplayName("Multiple runs choose longest")
    void testMultipleRuns() {
        assertEquals(3, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{5, 6, 7, 10, 11}));
    }

    @Test
    @DisplayName("Array with duplicates resets run")
    void testDuplicatesReset() {
        assertEquals(2, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{1, 2, 2, 3}));
    }

    @Test
    @DisplayName("Negative numbers in run")
    void testNegativeNumbers() {
        assertEquals(4, Task163_CLAUDE_claude_3_5_sonnet_20240620.longestRun(new int[]{-2, -1, 0, 1}));
    }
}
