package llama3.task166;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task166Test {

    @Test
    public void test_case_1() {
        int[] input = {6, 3, -2, 5, -8, 2, -2};
        int[] expected = {2, 3, -2, 5, -8, 6, -2};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_2() {
        int[] input = {6, 5, 4, -1, 3, 2, -1, 1};
        int[] expected = {1, 2, 3, -1, 4, 5, -1, 6};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_3() {
        int[] input = {-5, -5, -5, -5, 7, -5};
        int[] expected = {-5, -5, -5, -5, 7, -5};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_4() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_5() {
        int[] input = {10, -10, 20, -20};
        int[] expected = {10, -10, 20, -20};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_6() {
        int[] input = {9, 3, -3, -2, 7};
        int[] expected = {3, 7, -3, -2, 9};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_7() {
        int[] input = {5, 4, -1, -2, 1};
        int[] expected = {1, 4, -1, -2, 5};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_8() {
        int[] input = {-3, -2, -1};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_9() {
        int[] input = {100, -50, 75, -25};
        int[] expected = {75, -50, 100, -25};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }

    @Test
    public void test_case_10() {
        int[] input = {2, 1, -9, -8};
        int[] expected = {1, 2, -9, -8};
        assertArrayEquals(expected, Task166_PERPLEXITY_llama_3_sonar_large_32k_chat.posNegSort(input));
    }
}
