package llama3.task144;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Task144Test {

    private int[] parseInput(String input) {
        if (input.isEmpty()) {
            return new int[0];
        }
        String[] parts = input.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    private int[] simulateExpectedMerge(String input1, String input2) {
        int[] arr1 = parseInput(input1);
        int[] arr2 = parseInput(input2);
        int[] merged = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        Arrays.sort(merged);
        return merged;
    }

    @Test
    public void test_empty_arrays() {
        assertArrayEquals(new int[]{}, simulateExpectedMerge("", ""));
    }

    @Test
    public void test_one_empty_array() {
        assertArrayEquals(new int[]{1, 3, 5}, simulateExpectedMerge("", "1 3 5"));
        assertArrayEquals(new int[]{2, 4, 6}, simulateExpectedMerge("2 4 6", ""));
    }

    @Test
    public void test_single_element_arrays() {
        assertArrayEquals(new int[]{1, 1}, simulateExpectedMerge("1", "1"));
        assertArrayEquals(new int[]{1, 2}, simulateExpectedMerge("1", "2"));
    }

    @Test
    public void test_different_sizes_with_all_smaller_elements() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, simulateExpectedMerge("1 2 3", "4 5 6"));
    }

    @Test
    public void test_some_overlapping_elements() {
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 5}, simulateExpectedMerge("1 3 5", "2 3 4"));
    }

    @Test
    public void test_all_elements_same() {
        assertArrayEquals(new int[]{2, 2, 2, 2, 2, 2}, simulateExpectedMerge("2 2 2", "2 2 2"));
    }

    @Test
    public void test_interleaving_elements() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, simulateExpectedMerge("1 3 5 7", "2 4 6 8"));
    }

    @Test
    public void test_large_element_diff() {
        assertArrayEquals(new int[]{1, 2, 1000, 2000, 3000}, simulateExpectedMerge("1 2", "1000 2000 3000"));
    }

    @Test
    public void test_reverse_order_arrays() {
        assertArrayEquals(new int[]{4, 5, 6, 7, 8, 9}, simulateExpectedMerge("9 7 5", "8 6 4"));
    }
}
