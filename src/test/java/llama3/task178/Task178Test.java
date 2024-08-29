package llama3.task178;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task178Test {

    private Task178_PERPLEXITY_llama_3_sonar_large_32k_chat solution;

    @BeforeEach
    void setUp() {
        solution = new Task178_PERPLEXITY_llama_3_sonar_large_32k_chat();
    }

    @Test
    void testSingleElementEqualToK() {
        int[] nums = {1};
        int k = 1;
        assertEquals(1, solution.shortestSubarray(nums, k));
    }

    @Test
    void testTwoElementsNotEnoughSum() {
        int[] nums = {1, 2};
        int k = 4;
        assertEquals(-1, solution.shortestSubarray(nums, k));
    }

    @Test
    void testThreeElementsExactlyEqualSum() {
        int[] nums = {2, -1, 2};
        int k = 3;
        assertEquals(3, solution.shortestSubarray(nums, k));
    }

    @Test
    void testMultipleElementsWithSubarrayAtEnd() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        assertEquals(2, solution.shortestSubarray(nums, k));
    }

    @Test
    void testNegativeNumbersWithPositiveK() {
        int[] nums = {-1, -2, 3, 4};
        int k = 6;
        assertEquals(-1, solution.shortestSubarray(nums, k));
    }

    @Test
    void testSubarrayWithNegativeAndPositiveNumbers() {
        int[] nums = {4, -1, 2, 1};
        int k = 5;
        assertEquals(-1, solution.shortestSubarray(nums, k));
    }

    @Test
    void testAllElementsNegative() {
        int[] nums = {-1, -2, -3, -4};
        int k = -5;
        assertEquals(-1, solution.shortestSubarray(nums, k));
    }

    @Test
    void testLargeArrayWithPositiveNumbers() {
        int[] nums = new int[100000];
        Arrays.fill(nums, 1);
        int k = 100000;
        assertEquals(100000, solution.shortestSubarray(nums, k));
    }

    @Test
    void testLargeArrayWithMixedNumbers() {
        int[] nums = new int[100000];
        Arrays.fill(nums, -1);
        nums[50000] = 100000;
        int k = 50000;
        assertEquals(1, solution.shortestSubarray(nums, k));
    }

    @Test
    void testSubarrayWithExactMatch() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1};
        int k = 7;
        assertEquals(7, solution.shortestSubarray(nums, k));
    }
}
