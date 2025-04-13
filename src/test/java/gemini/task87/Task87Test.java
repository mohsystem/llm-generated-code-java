package gemini.task87;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class Task87Test {

    @Test
    public void testBinarySearchFound() {
        int[] array = {10, 20, 30, 40, 50};
        int result = Task87_GEMINI_gemini_1_5_pro_001.binarySearch(array, 30);
        assertEquals(2, result);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] array = {10, 20, 30, 40, 50};
        int result = Task87_GEMINI_gemini_1_5_pro_001.binarySearch(array, 35);
        assertEquals(-1, result);
    }

    @Test
    public void testGeneratedArrayIsSorted() {
        int[] arr = Task87_GEMINI_gemini_1_5_pro_001.generateSortedArray(1000);
        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i], "Array is not sorted at index " + i);
        }
    }
}
