package gtp4o.task177;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task177Test {

    @Test
    public void testCase1() {
        assertEquals(37, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{10, 2, -10, 5, 20}, 2));
    }

    @Test
    public void testCase2() {
        assertEquals(-1, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{-1, -2, -3}, 1));
    }

    @Test
    public void testCase3() {
        assertEquals(23, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{10, -2, -10, -5, 20}, 2));
    }

    @Test
    public void testCase4() {
        assertEquals(15, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    public void testCase5() {
        assertEquals(1, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{-1, 0, 1}, 2));
    }

    @Test
    public void testCase6() {
        assertEquals(6, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{1, -1, 2, 3, -2}, 2));
    }

    @Test
    public void testCase7() {
        assertEquals(12, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{5, -1, 3, -2, 4, -1}, 3));
    }

    @Test
    public void testCase8() {
        assertEquals(6, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{2, 1, -2, 3, -4}, 1));
    }

    @Test
    public void testCase9() {
        assertEquals(18, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{10, -2, 3, -4, 5}, 4));
    }

    @Test
    public void testCase10() {
        assertEquals(14, Task177_OPENAI_gpt_4o.maxSubsequenceSum(new int[]{1, -2, 3, 10, -1}, 2));
    }
}
