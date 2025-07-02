package claude.task177;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task177Test {

    @Test
    void testCase1() {
        Solution solution = new Solution();
        int[] nums = {10, 2, -10, 5, 20};
        int k = 2;
        assertEquals(37, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase2() {
        Solution solution = new Solution();
        int[] nums = {-1, -2, -3};
        int k = 1;
        assertEquals(-1, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase3() {
        Solution solution = new Solution();
        int[] nums = {10, -2, -10, -5, 20};
        int k = 2;
        assertEquals(23, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase4() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        assertEquals(15, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase5() {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1};
        int k = 2;
        assertEquals(1, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase6() {
        Solution solution = new Solution();
        int[] nums = {1, -1, 2, 3, -2};
        int k = 2;
        assertEquals(6, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase7() {
        Solution solution = new Solution();
        int[] nums = {5, -1, 3, -2, 4, -1};
        int k = 3;
        assertEquals(12, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase8() {
        Solution solution = new Solution();
        int[] nums = {2, 1, -2, 3, -4};
        int k = 1;
        assertEquals(6, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase9() {
        Solution solution = new Solution();
        int[] nums = {10, -2, 3, -4, 5};
        int k = 4;
        assertEquals(18, solution.constrainedSubsetSum(nums, k));
    }

    @Test
    void testCase10() {
        Solution solution = new Solution();
        int[] nums = {1, -2, 3, 10, -1};
        int k = 2;
        assertEquals(14, solution.constrainedSubsetSum(nums, k));
    }
}
