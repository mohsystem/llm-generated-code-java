package gemini.task170;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task170Test {

    @Test
    void testExample1() {
        Solution sol = new Solution();
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        int expected = 3;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }

    @Test
    void testExample2() {
        Solution sol = new Solution();
        int[] nums = {0};
        int lower = 0, upper = 0;
        int expected = 1;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }

    @Test
    void testAllZeroes() {
        Solution sol = new Solution();
        int[] nums = {0, 0, 0};
        int lower = 0, upper = 0;
        int expected = 6;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }

    @Test
    void testNegativeRange() {
        Solution sol = new Solution();
        int[] nums = {1, -1, 1, -1};
        int lower = -1, upper = -1;
        int expected = 4;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }

    @Test
    void testLargeNumbers() {
        Solution sol = new Solution();
        int[] nums = {Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0};
        int lower = -100, upper = 100;
        int expected = 2;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }

    @Test
    void testEmptyArray() {
        Solution sol = new Solution();
        int[] nums = {};
        int lower = 0, upper = 0;
        int expected = 0;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }

    @Test
    void testSingleElementOutOfRange() {
        Solution sol = new Solution();
        int[] nums = {5};
        int lower = -2, upper = 2;
        int expected = 0;
        assertEquals(expected, sol.rangeSum(nums, lower, upper));
    }
}
