package llama3.task146;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Task146Test {

    private int calculateMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    @Test
    void testMissingNumberAtStart() {
        int[] arr = {2, 3, 4, 5, 6};
        assertEquals(1, calculateMissingNumber(arr));
    }

    @Test
    void testMissingNumberAtEnd() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(6, calculateMissingNumber(arr));
    }

    @Test
    void testMissingNumberInMiddle() {
        int[] arr = {1, 2, 4, 5, 6};
        assertEquals(3, calculateMissingNumber(arr));
    }

    @Test
    void testMissingNumberInLargeArray() {
        int[] arr = new int[9999];
        for (int i = 1, j = 0; i <= 10000; i++) {
            if (i != 5000) {
                arr[j++] = i;
            }
        }
        assertEquals(5000, calculateMissingNumber(arr));
    }

    @Test
    void testSingleMissingNumber() {
        int[] arr = {1};
        assertEquals(2, calculateMissingNumber(arr));
    }

    @Test
    void testLargeArrayWithSmallMissingNumber() {
        int[] arr = new int[9999];
        for (int i = 2, j = 0; i <= 10000; i++) {
            arr[j++] = i;
        }
        assertEquals(1, calculateMissingNumber(arr));
    }

    @Test
    void testLargeArrayWithMissingNumberAtMiddle() {
        int[] arr = new int[9999];
        for (int i = 1, j = 0; i <= 10000; i++) {
            if (i != 5000) {
                arr[j++] = i;
            }
        }
        assertEquals(5000, calculateMissingNumber(arr));
    }

    @Test
    void testConsecutiveNumbersMissingOne() {
        int[] arr = {10, 11, 13, 14, 15};
        assertEquals(12, calculateMissingNumber(arr));
    }

    @Test
    void testMissingNumberAtEndOfSmallArray() {
        int[] arr = {1, 2, 3, 4};
        assertEquals(5, calculateMissingNumber(arr));
    }

    @Test
    void testMissingNumberAtStartOfSmallArray() {
        int[] arr = {2, 3, 4, 5};
        assertEquals(1, calculateMissingNumber(arr));
    }
}
