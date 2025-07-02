package gtp4o.task171;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task171Test {

    @Test
    public void testCase1() {
        int[] input = {1, 3, 2, 3, 1};
        assertEquals(2, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase2() {
        int[] input = {2, 4, 3, 5, 1};
        assertEquals(3, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase3() {
        int[] input = {1, 2, 3, 4, 5};
        assertEquals(0, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase4() {
        int[] input = {5, 4, 3, 2, 1};
        assertEquals(6, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase5() {
        int[] input = {1, 5, 2, 6, 3};
        assertEquals(2, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase6() {
        int[] input = {1};
        assertEquals(0, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase7() {
        int[] input = {3, 1, 4, 2, 5};
        assertEquals(1, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase8() {
        int[] input = {10, 5, 3, 2, 1};
        assertEquals(6, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase9() {
        int[] input = {4, 2, 6, 1, 3};
        assertEquals(3, Task171_OPENAI_gpt_4o.reversePairs(input));
    }

    @Test
    public void testCase10() {
        int[] input = {7, 5, 8, 2, 4};
        assertEquals(3, Task171_OPENAI_gpt_4o.reversePairs(input));
    }
}
