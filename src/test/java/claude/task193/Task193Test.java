package claude.task193;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task193Test {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testExample1() {
        int[] nums = {1, 1, 2};
        assertFalse(solution.xorGame(nums));
    }

    @Test
    void testExample2() {
        int[] nums = {0, 1};
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testExample3() {
        int[] nums = {1, 2, 3};
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0};
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testSingleElement() {
        int[] nums = {5};
        assertFalse(solution.xorGame(nums));
    }

    @Test
    void testTwoElementsSame() {
        int[] nums = {2, 2};
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testTwoElementsDifferent() {
        int[] nums = {3, 4};
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testFourElementsAllSame() {
        int[] nums = {7, 7, 7, 7};
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testLargeInput() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        assertTrue(solution.xorGame(nums));
    }

    @Test
    void testEvenLengthWithNonZeroXor() {
        int[] nums = {1, 2, 3, 4};
        assertTrue(solution.xorGame(nums));
    }
}
