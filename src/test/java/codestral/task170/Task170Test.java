package codestral.task170;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task170Test {

    @Test
    void testExample1() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        int expected = 3;
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }

    @Test
    void testExample2() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {0};
        int lower = 0, upper = 0;
        int expected = 1;
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }

    @Test
    void testAllZeroes() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {0, 0, 0};
        int lower = 0, upper = 0;
        int expected = 6; // كل المصفوفات الجزئية = 0
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }

    @Test
    void testNegativeRange() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {1, -1, 1, -1};
        int lower = -1, upper = -1;
        int expected = 4;
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }

    @Test
    void testLargeNumbers() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0};
        int lower = -100, upper = 100;
        int expected = 2;
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }

    @Test
    void testEmptyArray() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {};
        int lower = 0, upper = 0;
        int expected = 0;
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }

    @Test
    void testSingleElementOutOfRange() {
        Task170_MISTRAL_codestral_latest sol = new Task170_MISTRAL_codestral_latest();
        int[] nums = {5};
        int lower = -2, upper = 2;
        int expected = 0;
        assertEquals(expected, sol.countRangeSum(nums, lower, upper));
    }
}
