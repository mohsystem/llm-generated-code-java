package llama3.task163;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task163Test {

    @Test
    @DisplayName("Empty array should return 0")
    void testEmptyArray() {
        assertEquals(0, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{}));
    }

    @Test
    @DisplayName("Single element array should return 1")
    void testSingleElement() {
        assertEquals(1, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{42}));
    }

    @Test
    @DisplayName("No consecutive numbers should return 1")
    void testNoConsecutive() {
        assertEquals(1, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{3, 5, 7, 10}));
    }

    @Test
    @DisplayName("Strictly increasing run after sort")
    void testIncreasingAfterSort() {
        assertEquals(4, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{4, 2, 3, 1}));
    }

    @Test
    @DisplayName("All duplicates should return 1")
    void testAllDuplicates() {
        assertEquals(1, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{2,2,2,2}));
    }

    @Test
    @DisplayName("Mixed list yields longest sorted run of 2")
    void testMixedList() {
        assertEquals(2, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{1,2,3,2,1}));
    }

    @Test
    @DisplayName("Negative numbers produce correct run length")
    void testNegativeNumbers() {
        assertEquals(4, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{-2, -1, 0, 1}));
    }

    @Test
    @DisplayName("Separated sequences both length 3, choose max")
    void testSeparatedSequences() {
        assertEquals(3, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{10,11,12,1,2,3}));
    }

    @Test
    @DisplayName("Continuous distinct sequence of 6 elements")
    void testContinuousDistinct() {
        assertEquals(6, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{1,3,2,4,6,5}));
    }

    @Test
    @DisplayName("Unsorted mixed numbers")
    void testUnsortedMixed() {
        assertEquals(4, Task163_PERPLEXITY_llama_3_sonar_large_32k_chat.longestRun(new int[]{8,3,5,4,6}));
    }
}