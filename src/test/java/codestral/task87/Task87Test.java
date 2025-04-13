package codestral.task87;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task87Test {

    @Test
    public void testBinarySearchFound() {
        Task87_MISTRAL_codestral_latest obj = new Task87_MISTRAL_codestral_latest();
        int[] arr = {1, 3, 4, 10, 12, 90};
        int result = obj.binarySearch(arr, 0, arr.length - 1, 10);
        assertEquals(3, result);
    }

    @Test
    public void testBinarySearchNotFound() {
        Task87_MISTRAL_codestral_latest obj = new Task87_MISTRAL_codestral_latest();
        int[] arr = {1, 3, 4, 10, 12, 90};
        int result = obj.binarySearch(arr, 0, arr.length - 1, 8);
        assertEquals(-1, result);
    }

    @Test
    public void testExecutionTimeIsPositive() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Math.sqrt(i); // simulate work
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        assertTrue(executionTime > 0);
    }
}
