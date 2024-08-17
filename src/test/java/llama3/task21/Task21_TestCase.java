package llama3.task21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task21_TestCase {

    @Test
    void testCase1() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase2() {
        int[] input = {5, 3, 2, 1, 4};
        int[] expected = {5, 3, 2, 4};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase3() {
        int[] input = {2, 2, 1, 2, 1};
        int[] expected = {2, 2, 2, 1};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase4() {
        int[] input = {1};
        int[] expected = {};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase5() {
        int[] input = {1, 1, 1, 1};
        int[] expected = {1, 1, 1};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase6() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase7() {
        int[] input = {2, 3, 2, 3, 1};
        int[] expected = {2, 3, 2, 3};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase8() {
        int[] input = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase9() {
        int[] input = {5, 6, 7, 8, 9};
        int[] expected = {6, 7, 8, 9};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }

    @Test
    void testCase10() {
        int[] input = {10, 10, 10};
        int[] expected = {10, 10};
        assertArrayEquals(expected, Task21_PERPLEXITY_llama_3_sonar_large_32k_chat.removeSmallest(input));
    }
}