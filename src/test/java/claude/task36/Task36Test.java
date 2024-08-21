package claude.task26;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task26_CLAUDE_claude_3_5_sonnet_20240620Test {

    @Test
    void testFindOdd_singleOddNumber() {
        assertEquals(7, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{7}));
    }

    @Test
    void testFindOdd_allEvenNumbers() {
        assertEquals(0, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{0}));
    }

    @Test
    void testFindOdd_oneOddMultipleTimes() {
        assertEquals(2, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{1, 1, 2}));
    }

    @Test
    void testFindOdd_zerosAndOnes() {
        assertEquals(0, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{0, 1, 0, 1, 0}));
    }

    @Test
    void testFindOdd_complexOddPattern() {
        assertEquals(4, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));
    }

    @Test
    void testFindOdd_singleZero() {
        assertEquals(0, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{0}));
    }

    @Test
    void testFindOdd_noOddNumbers() {
        assertEquals(0, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{})); // Edge case: empty array
    }

    @Test
    void testFindOdd_largeArray() {
        assertEquals(100, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{10, 10, 20, 20, 100}));
    }

    @Test
    void testFindOdd_allPairs() {
        assertEquals(0, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{8, 8, 9, 9, 10, 10}));
    }

    @Test
    void testFindOdd_singleNegativeOddNumber() {
        assertEquals(-5, Task26_CLAUDE_claude_3_5_sonnet_20240620.findOdd(new int[]{-5, 1, 1}));
    }
}