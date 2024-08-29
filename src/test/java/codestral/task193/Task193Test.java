package codestral.task193;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class Task193_MISTRAL_codestral_latestTest {

    private Task193_MISTRAL_codestral_latest solution;

    @BeforeEach
    void setUp() {
        solution = new Task193_MISTRAL_codestral_latest();
    }

    @Test
    void testExample1() {
        int[] nums = {1, 1, 2};
        assertFalse(solution.xorGame(nums)); // XOR = 1 ^ 1 ^ 2 = 2 (non-zero) and length is 3 (odd)
    }

    @Test
    void testExample2() {
        int[] nums = {0, 1};
        assertFalse(solution.xorGame(nums)); // XOR = 0 ^ 1 = 1 (non-zero) and length is 2 (even)
    }

    @Test
    void testExample3() {
        int[] nums = {1, 2, 3};
        assertTrue(solution.xorGame(nums)); // XOR = 1 ^ 2 ^ 3 = 0 (zero) and length is 3 (odd)
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0}; // XOR = 0, length is 4 (even)
        assertFalse(solution.xorGame(nums)); // XOR is zero and length is even
    }

    @Test
    void testSingleElement() {
        int[] nums = {5}; // XOR = 5, length is 1 (odd)
        assertTrue(solution.xorGame(nums)); // XOR is non-zero and length is odd
    }

    @Test
    void testTwoElementsSame() {
        int[] nums = {2, 2}; // XOR = 2 ^ 2 = 0, length is 2 (even)
        assertFalse(solution.xorGame(nums)); // XOR is zero and length is even
    }

    @Test
    void testTwoElementsDifferent() {
        int[] nums = {3, 4}; // XOR = 3 ^ 4 = 7, length is 2 (even)
        assertFalse(solution.xorGame(nums)); // XOR is non-zero and length is even
    }

    @Test
    void testFourElementsAllSame() {
        int[] nums = {7, 7, 7, 7}; // XOR = 7 ^ 7 ^ 7 ^ 7 = 0, length is 4 (even)
        assertFalse(solution.xorGame(nums)); // XOR is zero and length is even
    }

    @Test
    void testLargeInput() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        assertFalse(solution.xorGame(nums)); // XOR of range [0, 999] is non-zero, length is 1000 (even)
    }

    @Test
    void testEvenLengthWithNonZeroXor() {
        int[] nums = {1, 2, 3, 4}; // XOR = 1 ^ 2 ^ 3 ^ 4 = 4, length is 4 (even)
        assertFalse(solution.xorGame(nums)); // XOR is non-zero and length is even
    }
}
