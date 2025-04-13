package gtp4o.task87;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task87Test {

    @Test
    public void testBinarySearchFound() {
        int[] arr = {2, 3, 4, 10, 40};
        int result = Task87_OPENAI_gpt_4o.binarySearch(arr, 10);
        assertEquals(3, result);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {2, 3, 4, 10, 40};
        int result = Task87_OPENAI_gpt_4o.binarySearch(arr, 7);
        assertEquals(-1, result);
    }

    @Test
    public void testExecutionTimePositive() {
        long startTime = System.nanoTime();
        Task87_OPENAI_gpt_4o.binarySearch(new int[]{1, 2, 3, 4}, 3);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        assertTrue(executionTime > 0, "Execution time should be positive");
    }
}
