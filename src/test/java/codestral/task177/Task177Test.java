package codestral.task177;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task177Test {

    Task177_MISTRAL_codestral_latest solution = new Task177_MISTRAL_codestral_latest();

    @Test
    void testCase1() {
        assertEquals(37, solution.maxSumSubsequence(new int[]{10, 2, -10, 5, 20}, 2));
    }

    @Test
    void testCase2() {
        assertEquals(-1, solution.maxSumSubsequence(new int[]{-1, -2, -3}, 1));
    }

    @Test
    void testCase3() {
        assertEquals(23, solution.maxSumSubsequence(new int[]{10, -2, -10, -5, 20}, 2));
    }

    @Test
    void testCase4() {
        assertEquals(15, solution.maxSumSubsequence(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void testCase5() {
        assertEquals(1, solution.maxSumSubsequence(new int[]{-1, 0, 1}, 2));
    }

    @Test
    void testCase6() {
        assertEquals(6, solution.maxSumSubsequence(new int[]{1, -1, 2, 3, -2}, 2));
    }

    @Test
    void testCase7() {
        assertEquals(12, solution.maxSumSubsequence(new int[]{5, -1, 3, -2, 4, -1}, 3));
    }

    @Test
    void testCase8() {
        assertEquals(6, solution.maxSumSubsequence(new int[]{2, 1, -2, 3, -4}, 1));
    }

    @Test
    void testCase9() {
        assertEquals(18, solution.maxSumSubsequence(new int[]{10, -2, 3, -4, 5}, 4));
    }

    @Test
    void testCase10() {
        assertEquals(14, solution.maxSumSubsequence(new int[]{1, -2, 3, 10, -1}, 2));
    }
}
