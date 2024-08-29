package gtp4o.task179;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task179Test {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testCase1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase3() {
        int[] nums = {1, -1};
        int k = 1;
        int[] expected = {1, -1};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase4() {
        int[] nums = {1, -1, -1, 1, 1, 1};
        int k = 3;
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase5() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int[] expected = {2, 3, 4, 5};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase6() {
        int[] nums = {9, 11};
        int k = 2;
        int[] expected = {11};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase7() {
        int[] nums = {4, -2};
        int k = 2;
        int[] expected = {4};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase8() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        int[] expected = {4, 5, 6, 7};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase9() {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        int k = 3;
        int[] expected = {4, 4, 6, 6, 6, 5};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }

    @Test
    void testCase10() {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] expected = {3, 3, 2, 5};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
}
