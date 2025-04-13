package llama3.task87;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class Task87Test {

    @Test
    public void testBinarySearchFound() {
        int[] arr = {10, 20, 30, 40, 50};
        int result = Task87_PERPLEXITY_llama_3_sonar_large_32k_chat.binarySearch(arr, 30);
        assertEquals(2, result);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {10, 20, 30, 40, 50};
        int result = Task87_PERPLEXITY_llama_3_sonar_large_32k_chat.binarySearch(arr, 35);
        assertEquals(-1, result);
    }

    @Test
    public void testSortedArrayGeneratedCorrectly() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr); // التأكد من الترتيب لا مشكلة هنا

        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]);
        }
    }
}
