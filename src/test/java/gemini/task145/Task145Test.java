package gemini.task145;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task145Test {

    private int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    @Test
    void testPositiveNumbers() {
        int[] arr = {1, 2, 3, 4, 5};
        int expectedSum = 15;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4, -5};
        int expectedSum = -1;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testMixedNumbers() {
        int[] arr = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        int expectedSum = 9;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        int expectedSum = 42;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testAllZeroes() {
        int[] arr = {0, 0, 0, 0, 0};
        int expectedSum = 0;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testLargeArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        int expectedSum = 1000;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testAlternatingSigns() {
        int[] arr = {3, -1, 4, -1, 2, 1, -5, 4};
        int expectedSum = 8;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testLargePositiveAndNegativeNumbers() {
        int[] arr = {10, -1, -1, 10, -1, 10, -1};
        int expectedSum = 27;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testSubarrayAtTheEnd() {
        int[] arr = {1, -2, -3, 4, 5};
        int expectedSum = 9;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testSubarrayAtTheStart() {
        int[] arr = {6, -1, -2, 1, 2};
        int expectedSum = 6;
        int actualSum = sumArray(Task145_GEMINI_gemini_1_5_pro_001.maxSubarraySum(arr));
        assertEquals(expectedSum, actualSum);
    }
}
