package gemini.task193;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testExample1() {
        int[] nums = {1, 1, 2};
        assertFalse(solution.xorGame(nums)); // Expected: false
    }

    @Test
    void testExample2() {
        int[] nums = {0, 1};
        assertTrue(solution.xorGame(nums)); // Expected: true
    }

    @Test
    void testExample3() {
        int[] nums = {1, 2, 3};
        assertTrue(solution.xorGame(nums)); // Expected: true
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0}; // XOR is 0, length is 4 (even)
        assertTrue(solution.xorGame(nums)); // Expected: true
    }

    @Test
    void testSingleElement() {
        int[] nums = {5}; // XOR is 5, length is 1 (odd)
        assertFalse(solution.xorGame(nums)); // Expected: false
    }

    @Test
    void testTwoElementsSame() {
        int[] nums = {2, 2}; // XOR is 0, length is 2 (even)
        assertTrue(solution.xorGame(nums)); // Expected: true
    }

    @Test
    void testTwoElementsDifferent() {
        int[] nums = {3, 4}; // XOR is 7, length is 2 (even)
        assertTrue(solution.xorGame(nums)); // Expected: true
    }

    @Test
    void testFourElementsAllSame() {
        int[] nums = {7, 7, 7, 7}; // XOR is 0, length is 4 (even)
        assertTrue(solution.xorGame(nums)); // Expected: true
    }

    @Test
    void testLargeInput() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        assertTrue(solution.xorGame(nums)); // Expected: false
    }

    @Test
    void testEvenLengthWithNonZeroXor() {
        int[] nums = {1, 2, 3, 4}; // XOR is 4, length is 4 (even)
        assertTrue(solution.xorGame(nums)); // Expected: true
    }
}
